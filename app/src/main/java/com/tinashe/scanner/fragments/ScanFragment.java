package com.tinashe.scanner.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.melnykov.fab.FloatingActionButton;
import com.tinashe.scanner.R;
import com.tinashe.scanner.fragments.callbacks.OnScanInteractionListener;


public class ScanFragment extends Fragment implements View.OnClickListener{

   // private OnScanInteractionListener mListener;

    private TextView mScanResults;

    private Button mBtnProductSearch;
    private Button mBtnWebSearch;

    private FloatingActionButton mFab;

    public ScanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);

        if(!isAdded()){
            return;
        }

        mScanResults = (TextView) getView().findViewById(R.id.scan_results);

        mBtnProductSearch = (Button) getView().findViewById(R.id.product_search);
        mBtnWebSearch = (Button) getView().findViewById(R.id.web_search);

        mFab = (FloatingActionButton) getView().findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator.initiateScan(getActivity());
            }
        });

    }



    public void onScanCompleted(IntentResult scanResult) {

        mScanResults.setText(scanResult.getContents());

        mBtnWebSearch.setOnClickListener(this);
        mBtnProductSearch.setOnClickListener(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            OnScanInteractionListener mListener = (OnScanInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnScanInteractionListener");
        }
    }


    @Override
    public void onClick(View v) {

    }
}
