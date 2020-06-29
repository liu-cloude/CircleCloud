package com.xingwang.swip.utils;

import com.beautydefinelibrary.BeautyDefine;
import com.blankj.utilcode.util.EmptyUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpHeaderInterceptor implements Interceptor {
    private String mAuth= BeautyDefine.getAccountDefine().getAuthStr();
    //private String mAuth="Yt7daGui/arohoSc7Kzgam07KF+iDO9M/dM1k/cZ/eG17lL99fvNn7utihSkxEKaMx4HqCrW/1ooz5zTOeHLoHqt2AIfuHEmh/LB1qxB2Rk=";
    public HttpHeaderInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder=chain.request().newBuilder();
        if (EmptyUtils.isNotEmpty(mAuth))
            builder.addHeader("Authorization",mAuth);
        return chain.proceed(builder.build());
    }
}
