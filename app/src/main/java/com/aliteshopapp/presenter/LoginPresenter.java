package com.aliteshopapp.presenter;

import com.aliteshopapp.base.view.BaseView;
import com.aliteshopapp.entity.Login;
import com.aliteshopapp.entity.LoginBean;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface LoginPresenter {
    interface View extends BaseView<LoginBean> {
    }
    interface Presenter {
        void fetchLogin(Login login);
    }
}
