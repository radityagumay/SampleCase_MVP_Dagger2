package net.radityalabs.samplecase.network;

import net.radityalabs.samplecase.model.ItemModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by radityagumay on 2/11/17.
 */

public interface RestService {

    @GET
    Observable<List<ItemModel>> getItems();
}
