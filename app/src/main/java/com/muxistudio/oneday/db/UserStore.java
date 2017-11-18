package com.muxistudio.oneday.db;

import com.muxistudio.oneday.App;

import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by fengminchao on 17/11/18
 */

public class UserStore {

    public static Observable<User> insertUser(final String name, final String pwd){
        return Observable.just(null)
                .observeOn(Schedulers.io())
                .map(new Func1<Object, User>() {
                    @Override
                    public User call(Object o) {
                        User user = new User();
                        user.setName(name);
                        user.setPwd(pwd);
                        UserDao dao = App.getDaoSession().getUserDao();
                        dao.insert(user);
                        return user;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<List<User>> getUsers(){
        return Observable.fromCallable(new Callable() {

            @Override
            public List<User> call() throws Exception {
                UserDao dao = App.getDaoSession().getUserDao();
                List<User> userList = dao.loadAll();
                return userList;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

//    public static Observable<List<User>> updateUser(){
//
//    }
}
