package com.chiemy.example.databindingexample;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by hotbody on 16/5/13.
 */
public class StringUtils {

    public static String capitalize(String text){
        if (!TextUtils.isEmpty(text)){
            return text.toUpperCase();
        }
        return text;
    }

    public static String packageName(Context context){
        return context.getPackageName();
    }
}
