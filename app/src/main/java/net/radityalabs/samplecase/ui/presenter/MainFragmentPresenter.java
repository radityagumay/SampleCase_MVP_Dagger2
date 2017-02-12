package net.radityalabs.samplecase.ui.presenter;

import android.support.annotation.NonNull;

import net.radityalabs.samplecase.model.ItemModel;
import net.radityalabs.samplecase.ui.fragment.MainFragment;
import net.radityalabs.samplecase.ui.manager.MainFragmentManager;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by radityagumay on 2/11/17.
 */

public class MainFragmentPresenter {

    private MainFragment mMainFragment;
    private MainFragmentManager mMainFragmentManager;

    public MainFragmentPresenter(@NonNull MainFragment mainFragment, @NonNull MainFragmentManager mainFragmentManager) {
        this.mMainFragment = mainFragment;
        this.mMainFragmentManager = mainFragmentManager;
    }

    public void loadItems() {
        mMainFragmentManager.getItemsRepository().subscribe(new Consumer<List<ItemModel>>() {
            @Override
            public void accept(List<ItemModel> items) throws Exception {
                mMainFragment.bindItems(items);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mMainFragment.loadItemsFailed(throwable.getMessage());
            }
        });
    }
}
