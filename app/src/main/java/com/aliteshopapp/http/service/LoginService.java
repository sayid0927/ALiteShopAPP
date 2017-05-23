package com.aliteshopapp.http.service;

import com.aliteshopapp.base.app.AppConstants;
import com.aliteshopapp.entity.Login;
import com.aliteshopapp.entity.LoginBean;
import com.aliteshopapp.http.BaseResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/30.
 */

public interface LoginService {

    @POST(AppConstants.auth_shop_login2)
    Observable <BaseResponse<LoginBean>> getLogin(@Body Login login);
}
