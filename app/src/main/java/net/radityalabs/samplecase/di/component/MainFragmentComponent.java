package net.radityalabs.samplecase.di.component;

import net.radityalabs.samplecase.di.module.MainFragmentModule;
import net.radityalabs.samplecase.ui.fragment.MainFragment;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by radityagumay on 2/11/17.
 */

@Singleton
@Subcomponent(
        modules = MainFragmentModule.class
)
public interface MainFragmentComponent {
    MainFragment inject(MainFragment fragment);
}
