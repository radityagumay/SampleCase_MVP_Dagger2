package net.radityalabs.samplecase;

import android.app.Application;
import android.content.Context;

import net.radityalabs.samplecase.di.component.ApplicationComponent;
import net.radityalabs.samplecase.di.component.DaggerApplicationComponent;
import net.radityalabs.samplecase.di.module.ApplicationModule;

/**
 * Created by radityagumay on 2/11/17.
 */

public class SampleApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger();
    }

    private void setupDagger() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static SampleApplication get(Context context) {
        return (SampleApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
