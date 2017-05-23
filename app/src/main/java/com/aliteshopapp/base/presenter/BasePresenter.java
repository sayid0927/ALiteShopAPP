package com.aliteshopapp.base.presenter;

import com.aliteshopapp.base.app.AppConstants;
import com.aliteshopapp.base.view.BaseView;
import com.aliteshopapp.http.Callback;
import com.aliteshopapp.http.HttpUtils;
import com.aliteshopapp.http.LifeSubscription;
import com.aliteshopapp.http.Stateful;

import java.util.List;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/22.
 */

public class BasePresenter<T extends BaseView> {

    protected T mView;//指的是界面，也就是BaseFragment或者BaseActivity

    private Callback callback;

    public void attachView(LifeSubscription mLifeSubscription) {
        this.mView = (T) mLifeSubscription;
    }

    protected <T> void invoke(Observable<T> observable, Callback<T> callback) {
        this.callback = callback;
        HttpUtils.invoke((LifeSubscription) mView, observable, callback);
    }

    /**
     * 给子类检查返回集合是否为空
     * 这样子做虽然耦合度高，
     *
     * @param list
     */
    public void checkState(List list) {
        if (list.size() == 0) {
            if (mView instanceof Stateful)
                ((Stateful) mView).setState(AppConstants.STATE_EMPTY);
            return;
        }
    }

    public void detachView() {
        if (mView != null)
            mView = null;
        if (callback != null) {
            callback.detachView();
        }
    }
}
