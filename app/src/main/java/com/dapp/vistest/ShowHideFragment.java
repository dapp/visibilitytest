package com.dapp.vistest;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ShowHideFragment extends Fragment {
    boolean systemUiVisible = true;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vis, container, false);
        final InsetReportingLinearLayout layout = (InsetReportingLinearLayout) view.findViewById(R.id.container);
        layout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        textView =  (TextView) view.findViewById(R.id.textview);
        textView.setText("Show Hide Fragment");

        Button test = (Button) view.findViewById(R.id.test_button);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final MainActivity mainActivity = (MainActivity)getActivity();
                if (systemUiVisible) {
                    mainActivity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                                                                  | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                    mainActivity.getSupportActionBar().hide();

                    systemUiVisible = false;
                } else {
                    getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                    mainActivity.getSupportActionBar().show();

                    systemUiVisible = true;
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
    }

    public void onInsetsChanged(Rect insets) {
        if (textView != null) {
            textView.setText(insets.toString());
        }
    }
}
