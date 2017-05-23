package com.aliteshopapp.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliteshopapp.R;
import com.aliteshopapp.base.activity.BaseActivity;
import com.aliteshopapp.entity.LoginBean;
import com.aliteshopapp.http.BaseResponse;
import com.aliteshopapp.injector.http.LoginHttpModule;
import com.aliteshopapp.injector.http.component.activity.DaggerLoginComponent;
import com.aliteshopapp.presenter.LoginPresenter;
import com.aliteshopapp.presenter.impl.LoginPresenterImpl;
import com.blankj.utilcode.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {


    @BindView(R.id.llExit)
    LinearLayout llExit;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.llRight)
    LinearLayout llRight;
    @BindView(R.id.connection_title)
    RelativeLayout connectionTitle;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.ll_ohter_login)
    LinearLayout llOhterLogin;
    @BindView(R.id.layout_login)
    LinearLayout layoutLogin;
    @BindView(R.id.btn_forget_pwd)
    Button btnForgetPwd;
    @BindView(R.id.btn_new_user)
    Button btnNewUser;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private long mExitTime = 0;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setStatusBar() {
        connectionTitle.setBackgroundColor(this.getResources().getColor(R.color.white));
        tvTitle.setVisibility(View.INVISIBLE);
        llExit.setVisibility(View.INVISIBLE);
        llRight.setVisibility(View.INVISIBLE);
    }

    @Override
    public void initView() {

        ButterKnife.bind(this);
        getSwipeBackLayout().setEnableGesture(false);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

        DaggerLoginComponent.builder().loginHttpModule(new LoginHttpModule()).build().injectLogin(this);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShortToast(this.getResources().getString(R.string.out_app));
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setState(int state) {

    }

    @Override
    public void onSuccessView(BaseResponse<LoginBean> mData) {
        LoginBean login = mData.getData();
        Logger.t("TAG").d(login);
    }

    @Override
    public void onFailView(String errorMsg) {
        ToastUtils.showShortToast(errorMsg);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_forget_pwd, R.id.btn_new_user, R.id.btn_login,R.id.edit_name, R.id.edit_password, R.id.llExit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_forget_pwd:
                break;
            case R.id.btn_new_user:
                break;
            case R.id.btn_login:
                break;
            case R.id.edit_name:

                break;
            case R.id.edit_password:
                break;
        }
    }
}
