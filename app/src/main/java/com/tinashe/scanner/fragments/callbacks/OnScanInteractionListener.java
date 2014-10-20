package com.tinashe.scanner.fragments.callbacks;

import com.google.zxing.integration.android.IntentResult;

/**
 * Created by tinashe on 2014/10/20.
 */
public interface OnScanInteractionListener {
    public void onScanCompleted(IntentResult scanResult);
}
