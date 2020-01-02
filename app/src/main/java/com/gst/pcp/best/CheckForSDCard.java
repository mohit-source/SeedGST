package com.gst.pcp.best;

import android.os.Environment;

/**
 * Created by PCP on 28-02-2018.
 */

public class CheckForSDCard {


    public boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

}
