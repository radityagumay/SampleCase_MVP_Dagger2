package net.radityalabs.samplecase.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.radityalabs.samplecase.R;
import net.radityalabs.samplecase.SampleApplication;
import net.radityalabs.samplecase.di.module.MainFragmentModule;
import net.radityalabs.samplecase.model.ItemModel;
import net.radityalabs.samplecase.ui.adapter.ItemAdapter;
import net.radityalabs.samplecase.ui.presenter.MainFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainFragment extends BaseFragment {

    public static final String TAG = MainFragment.class.getSimpleName();

    private static final String PARAM_1 = "param1";

    private List<ItemModel> mItems;
    private ItemAdapter mItemAdapter;

    @Inject
    MainFragmentPresenter mPresenter;
    @BindView(R.id.rv_items)
    RecyclerView rvItems;

    public static MainFragment newInstance(String param1) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_1, param1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInjection();
    }

    private void setupInjection() {
        SampleApplication.get(getContext()).getComponent().plus(new MainFragmentModule(this)).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

        mPresenter.loadItems();
    }

    private void initView() {
        mItems = new ArrayList<>();
        mItemAdapter = new ItemAdapter(mItems);

        rvItems.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvItems.setHasFixedSize(true);
        rvItems.setAdapter(mItemAdapter);
    }

    public void bindItems(@NonNull List<ItemModel> items) {
        mItems.addAll(items);
        mItemAdapter.notifyDataSetChanged();
    }

    public void loadItemsFailed(String message) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}
