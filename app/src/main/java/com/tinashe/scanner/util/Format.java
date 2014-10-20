package com.tinashe.scanner.util;

/**
 * Created by tinashe on 2014/10/20.
 */
public enum Format {

    UPC_A("UPC-A"),
    CODE_39("Code 39"),
    QR_CODE("QR Code"),
    UPC_E("UPC-E"),
    CODE_93("Code 93"),
    DATA_MATRIX("Data Matrix"),
    EAN_8("EAN-8"),
    CODE_128("Code 128"),
    EAN_13("EAN-13"),
    ITF("ITF"),
    RSS_14("RSS-14"),
    RSS_EXPANDED("RSS-Expanded");

    private String mName;

    private Format(String name){
        this.mName = name;
    }

    public String getName(){
        return mName;
    }

}
