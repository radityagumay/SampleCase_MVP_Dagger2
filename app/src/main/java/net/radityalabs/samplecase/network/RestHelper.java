package net.radityalabs.samplecase.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import net.radityalabs.samplecase.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by radityagumay on 2/11/17.
 */

public class RestHelper {

    private static final String TAG = RestHelper.class.getSimpleName();

    private static final long CONNECTION_TIMEOUT = 30 * 1000;
    private static final long READ_TIMEOUT = 30 * 1000;

    private static final Object LOCK = new Object();
    private static RestHelper sInstance;

    private RestService service;

    public static RestHelper getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new RestHelper();
            }
        }
        return sInstance;
    }

    private RestHelper() {
        Retrofit retrofit = buildRetrofit();
        service = retrofit.create(RestService.class);
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .client(buildHttpClient())
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private Gson buildGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }

    private OkHttpClient buildHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

    public RestService getRestService() {
        return this.service;
    }
}
