package net.radityalabs.samplecase.ui.manager;

import net.radityalabs.samplecase.model.ItemModel;
import net.radityalabs.samplecase.network.RestService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by radityagumay on 2/11/17.
 */

public class MainFragmentManager {

    private RestService mService;

    public MainFragmentManager(RestService service) {
        this.mService = service;
    }

    public Observable<List<ItemModel>> getItemsRepository() {
        return mService.getItems()
                .map(new Function<List<ItemModel>, List<ItemModel>>() {
                    @Override
                    public List<ItemModel> apply(List<ItemModel> itemModels) throws Exception {
                        List<ItemModel> items = new ArrayList<>();
                        return items;
                    }
                })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
