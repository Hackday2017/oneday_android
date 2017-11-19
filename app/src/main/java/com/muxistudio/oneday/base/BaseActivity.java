package com.muxistudio.oneday.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.muxistudio.oneday.event.EventClass;
import com.muxistudio.oneday.util.L;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by fengminchao on 17/11/18
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.i(" onCreate");
        if (isNeedEventBus()){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        L.i(" onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        L.i(" onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        L.i(" onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        L.i(" onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    public boolean isNeedEventBus(){
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventClass.EmptyEvent event){

    }
}
