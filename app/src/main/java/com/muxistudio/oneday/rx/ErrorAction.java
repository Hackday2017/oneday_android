package com.muxistudio.oneday.rx;

import rx.functions.Action1;

/**
 * Created by fengminchao on 17/11/18
 * rx异常处理
 */

public class ErrorAction implements Action1<Throwable>{

    @Override
    public void call(Throwable throwable) {
        throwable.printStackTrace();
    }
}
