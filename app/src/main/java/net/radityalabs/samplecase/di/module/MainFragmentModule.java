package net.radityalabs.samplecase.di.module;

import net.radityalabs.samplecase.di.scope.ActivityScope;
import net.radityalabs.samplecase.network.RestService;
import net.radityalabs.samplecase.ui.fragment.MainFragment;
import net.radityalabs.samplecase.ui.manager.MainFragmentManager;
import net.radityalabs.samplecase.ui.presenter.MainFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by radityagumay on 2/11/17.
 */

@Module
public class MainFragmentModule {

    private MainFragment mMainFragment;

    public MainFragmentModule(MainFragment mainFragment) {
        this.mMainFragment = mainFragment;
    }

    @Provides
    @ActivityScope
    MainFragment provideFragment() {
        return mMainFragment;
    }

    @Provides
    @ActivityScope
    MainFragmentPresenter provideFragmentPresenter(MainFragmentManager manager) {
        return new MainFragmentPresenter(mMainFragment, manager);
    }

    @Provides
    @ActivityScope
    MainFragmentManager provideCatalogueManager(RestService restService) {
        return new MainFragmentManager(restService);
    }
}
