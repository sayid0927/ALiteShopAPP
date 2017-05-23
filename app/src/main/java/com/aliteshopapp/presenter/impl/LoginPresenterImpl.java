package com.aliteshopapp.presenter.impl;

import com.aliteshopapp.base.presenter.BasePresenter;
import com.aliteshopapp.entity.Login;
import com.aliteshopapp.entity.LoginBean;
import com.aliteshopapp.http.BaseResponse;
import com.aliteshopapp.http.Callback;
import com.aliteshopapp.http.utils.RetrofitLoginHttpUtils;
import com.aliteshopapp.presenter.LoginPresenter;

import javax.inject.Inject;

public class LoginPresenterImpl extends BasePresenter<LoginPresenter.View> implements LoginPresenter.Presenter {
    private RetrofitLoginHttpUtils retrofitLoginHttpUtils;

    @Inject
    public LoginPresenterImpl(RetrofitLoginHttpUtils retrofitLoginHttpUtils) {
        this.retrofitLoginHttpUtils = retrofitLoginHttpUtils;
    }

    @Override
    public void fetchLogin(Login login) {
        invoke(retrofitLoginHttpUtils.fetchLogin(login),new Callback<BaseResponse<LoginBean>>(){
            @Override
            public void onSuccess(BaseResponse<LoginBean> data) {
                mView.onSuccessView(data);
            }

            @Override
            public void onFail(String msg) {
                    mView.onFailView(msg);
            }
        });
    }
}
