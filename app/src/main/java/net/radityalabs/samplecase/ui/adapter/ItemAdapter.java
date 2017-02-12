package net.radityalabs.samplecase.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.radityalabs.samplecase.model.ItemModel;
import net.radityalabs.samplecase.ui.viewholder.ItemViewHolder;

import java.util.List;

/**
 * Created by radityagumay on 2/11/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<ItemModel> mItems;

    public ItemAdapter(List<ItemModel> items) {
        this.mItems = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }
}
