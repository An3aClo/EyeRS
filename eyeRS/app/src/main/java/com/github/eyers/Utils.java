package com.github.eyers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Utilities to support the library. So basically anything that didn't fit anywhere else.
 * Created on 10/10/2017.
 *
 * @author Emilde
 */
public class Utils {

    public final static int App_Theme = 0;
    public final static int AppTheme_Red = 1;
    public final static int AppTheme_Yellow = 2;
    public final static int AppTheme_Green = 3;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(AppCompatActivity activity, int theme) {
//        sTheme = theme;
        EyeRS.PREFERENCES.putInteger("theme", theme);
        EyeRS.PREFERENCES.flush();
        // activity.setTheme(theme);
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(AppCompatActivity activity) {
        switch (getThemeID()) {
            case App_Theme:
                activity.setTheme(R.style.AppTheme);
                break;
            case AppTheme_Red:
                activity.setTheme(R.style.AppThemeRed);
                break;
            case AppTheme_Yellow:
                activity.setTheme(R.style.AppThemeYellow);
                break;
            case AppTheme_Green:
                activity.setTheme(R.style.AppThemeGreen);
                break;
        }
    }

    public static int getTheme() {
        switch (getThemeID()) {
            case AppTheme_Red:
                return (R.style.AppThemeRed);
            case AppTheme_Yellow:
                return (R.style.AppThemeYellow);
            case AppTheme_Green:
                return (R.style.AppThemeGreen);
            case App_Theme:
            default:
                return (R.style.AppTheme);
        }
    }

    static int getThemeID() {
        return EyeRS.PREFERENCES.getInteger("theme", App_Theme);
    }
}