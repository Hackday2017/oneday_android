package com.muxistudio.oneday.util;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.muxistudio.oneday.base.BaseActivity;
import com.muxistudio.oneday.base.BaseFragment;

import java.lang.reflect.Constructor;

/**
 * Created by fengminchao on 17/11/18
 */

public class FragmentUtils {

    public static void hideFragment(Fragment fragment, FragmentActivity activity) {
        if (fragment == null || activity == null || activity.isFinishing()) {
            return;
        }
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.hide(fragment);
        transaction.commitAllowingStateLoss();
    }

    public static void showFragment(Fragment fragment, FragmentActivity activity) {
        if (fragment == null || activity == null) {
            return;
        }
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
    }

    public static BaseFragment addFragment(BaseActivity fragmentActivity, Class<?> cls, Bundle bundle, int containerViewId,boolean addToBackStack) {
        if (fragmentActivity == null) {
            return null;
        }
        String tag = cls.getName();
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        BaseFragment fragment = null;
        BaseFragment oldFragment = null;
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (fragmentManager.findFragmentByTag(tag) != null && (fragmentManager.findFragmentByTag(tag)) instanceof BaseFragment) {
            oldFragment = (BaseFragment) fragmentManager.findFragmentByTag(tag);
            if (oldFragment != null) {
                if (bundle == null) {
                    if (!oldFragment.isAdded()) {
                        ft.add(containerViewId, oldFragment, tag);
                    }
                    if (oldFragment.isHidden()) {
                        ft.show(oldFragment);
                    }
                    ft.commitAllowingStateLoss();
                    return oldFragment;
                } else {
                    ft.remove(oldFragment);
                    ft.commitAllowingStateLoss();

                    ft = fragmentManager.beginTransaction();
                }
            }
        }
        fragment = createFragment(cls);
        if (fragment == null) {
            return null;
        }
        if (bundle != null) {
            fragment.setArguments(bundle);
        }

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.add(containerViewId, fragment, tag);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (!fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed()) {
                ft.commitAllowingStateLoss();
            }
        } else {
            if (!fragmentActivity.isFinishing()) {
                ft.commitAllowingStateLoss();
            }
        }
        return fragment;
    }

    public static BaseFragment createFragment(Class<?> cls) {
        Constructor<?> ctor;
        try {
            ctor = cls.getConstructor();
            Object object = ctor.newInstance();
            if (object instanceof BaseFragment) {
                return (BaseFragment) object;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
