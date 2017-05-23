package com.aliteshopapp.http.utils;

import com.aliteshopapp.entity.Login;
import com.aliteshopapp.entity.LoginBean;
import com.aliteshopapp.http.BaseResponse;
import com.aliteshopapp.http.HttpUtils;
import com.aliteshopapp.http.service.LoginService;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class RetrofitLoginHttpUtils extends HttpUtils {

    private LoginService loginService;

    public RetrofitLoginHttpUtils (LoginService loginService) {
        this.loginService = loginService;
    }

    public Observable<BaseResponse<LoginBean>> fetchLogin(Login login) {
       return loginService.getLogin(login);
    }
}
