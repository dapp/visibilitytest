package com.dapp.vistest;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    interface OnInsetsChangedListener{
        void onInsetsChanged(Rect insets);
    }

    InsetReportingFrameLayout layout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.insets);
        layout = (InsetReportingFrameLayout) findViewById(R.id.fragment_container);
        layout.setOnInsetsChangedListener(new OnInsetsChangedListener() {
            @Override
            public void onInsetsChanged(final Rect insets) {
                textView.setText(insets.toString());
                ShowHideFragment fragment = (ShowHideFragment) getSupportFragmentManager().findFragmentByTag("ShowHideFragment");
                if (fragment != null) {
                    fragment.onInsetsChanged(insets);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.test) {
            getSupportFragmentManager().beginTransaction()
                                       .replace(R.id.fragment_container, new ShowHideFragment(), "ShowHideFragment")
                                       .addToBackStack("ShowHideFragment").commit();
        }

        return super.onOptionsItemSelected(item);
    }

}
