package com.aliteshopapp.injector.http;

import com.aliteshopapp.http.service.LoginService;
import com.aliteshopapp.http.utils.RetrofitLoginHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class LoginHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideWeChatRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    LoginService provideWeChatService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }
    @Provides
    @Singleton
    RetrofitLoginHttpUtils provideRetrofitWeChatUtils(LoginService weChatService) {
        return new RetrofitLoginHttpUtils(weChatService);
    }
}
