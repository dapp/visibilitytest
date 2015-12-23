package com.dapp.vistest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class VisibleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vis, container, false);
        final View layout = view.findViewById(R.id.container);
        layout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        layout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        final TextView textView =  (TextView) view.findViewById(R.id.textview);
        textView.setText("This is the visible fragment");

        Button test = (Button) view.findViewById(R.id.test_button);
        test.setVisibility(View.GONE);

        return view;
    }
}
