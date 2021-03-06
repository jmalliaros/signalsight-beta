package com.projecttango.experiments.augmentedrealitysample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.scanner.ScanActivity;

/**
 * Created by iain on 2/20/16.
 */

public class CustomScanActivity extends ScanActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Hub hub = Hub.getInstance();
        if (!hub.init(this)) {
            Log.e("WTF", "Could not initialize the Hub.");
            finish();
            return;
        }


        if (hub.getConnectedDevices().size() > 0){
            hub.getConnectedDevices().get(0).vibrate(Myo.VibrationType.MEDIUM);
        }


        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1337, 1, "Return");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1337) {
            Intent intent = new Intent(this, AugmentedRealityActivity.class);
            this.startActivity(intent);
            return true;
        }
        return false;
    }
}