package com.tinashe.scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.tinashe.scanner.fragments.ScanFragment;
import com.tinashe.scanner.fragments.callbacks.OnScanInteractionListener;


public class MainActivity extends Activity implements OnScanInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            getFragmentManager().beginTransaction()
                    //.add(R.id.container, new PlaceholderFragment())
                    .replace(R.id.container, new ScanFragment(), ScanFragment.class.getName())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK){
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

            onScanCompleted(scanResult);
        }


    }

    @Override
    public void onScanCompleted(IntentResult scanResult) {
        ScanFragment fragment = (ScanFragment)getFragmentManager().findFragmentByTag(ScanFragment.class.getName());

        if(fragment != null){
            fragment.onScanCompleted(scanResult);
        }
    }
}
