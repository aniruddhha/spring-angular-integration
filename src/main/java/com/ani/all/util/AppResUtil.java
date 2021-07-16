package com.ani.all.util;

import com.ani.all.dto.AppRes;

public class AppResUtil {
    public static <T> AppRes<T> buildResponse(T t, String msg, String sts) {
        return AppRes.<T>builder()
                .dt(t)
                .msg(msg)
                .sts(sts)
                .build();
    }
}
