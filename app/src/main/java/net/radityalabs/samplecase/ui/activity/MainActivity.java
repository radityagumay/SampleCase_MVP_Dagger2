package net.radityalabs.samplecase.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import net.radityalabs.samplecase.R;
import net.radityalabs.samplecase.ui.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        replaceFragment(R.id.container, MainFragment.newInstance(""), MainFragment.TAG, MainFragment.TAG);
    }

    @Override
    protected Activity getLayoutId() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
