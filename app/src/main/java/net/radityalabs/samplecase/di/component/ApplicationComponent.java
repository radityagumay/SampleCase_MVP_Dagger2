package net.radityalabs.samplecase.di.component;

import net.radityalabs.samplecase.di.module.ApplicationModule;
import net.radityalabs.samplecase.di.module.MainFragmentModule;
import net.radityalabs.samplecase.di.module.RestModule;
import net.radityalabs.samplecase.ui.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by radityagumay on 2/11/17.
 */

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                RestModule.class
        }
)
public interface ApplicationComponent {
    void inject(BaseActivity activity);

    MainFragmentComponent plus(MainFragmentModule module);
}
