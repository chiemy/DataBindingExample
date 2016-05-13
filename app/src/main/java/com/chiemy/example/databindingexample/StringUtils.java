package com.chiemy.example.databindingexample;

import android.content.Context;
import android.util.Log;

/**
 * Created by hotbody on 16/5/13.
 */
public class StringUtils {

    public static String capitalize(String text){
        return text.toUpperCase();
    }

    public static String packageName(Context context){
        return context.getPackageName();
    }
}
