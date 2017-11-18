package com.muxistudio.oneday.db;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.muxistudio.oneday.App;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fengminchao on 17/11/18
 */

public class DiaryStore {

    private static final Type INTEGER_LIST_TYPE = new TypeToken<List<Integer>>(){}.getType();
    private static final Type STRING_LIST_TYPE = new TypeToken<List<String>>(){}.getType();

    public static Observable<Boolean> insertDiary(final String title, final int tag,final long time,final int rate, final List<Integer> questionList, final List<String> answerList){
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                DiaryDao dao = App.getDaoSession().getDiaryDao();
                String questionStr = new Gson().toJson(questionList,INTEGER_LIST_TYPE);
                String answerStr = new Gson().toJson(answerList,STRING_LIST_TYPE);
                Diary diary = new Diary(null,title,tag,time,rate,questionStr,answerStr);
                dao.insert(diary);
                return true;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<List<Diary>> getDiaries(){
        return Observable.fromCallable(new Callable<List<Diary>>() {
            @Override
            public List<Diary> call() throws Exception {
                DiaryDao dao = App.getDaoSession().getDiaryDao();
                List<Diary> diaryList = dao.loadAll();
                return diaryList;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<Boolean> updateDiary(final Diary diary){
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                DiaryDao dao = App.getDaoSession().getDiaryDao();
                dao.update(diary);
                return true;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<Boolean> deleteDiary(final Diary diary){
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                DiaryDao dao = App.getDaoSession().getDiaryDao();
                dao.delete(diary);
                return true;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
