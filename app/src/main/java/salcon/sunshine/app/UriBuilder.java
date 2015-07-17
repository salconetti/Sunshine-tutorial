package salcon.sunshine.app;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Javier on 17/07/2015.
 */
public abstract class UriBuilder  {

    private static final String LOG_TAG = UriBuilder.class.getSimpleName();
    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast/daily?";
    private static final String QUERY = "q";
    private static final String MODE = "mode";
    private static final String UNITS = "units";
    private static final String CNT = "cnt";
    private static String mode;
    private static String unit;
    private static String days;

    public static String getUri(String postalCode) throws MalformedURLException {
        mode = "json";
        unit = "metric";
        days = "7";
        Uri builtUri = Uri.parse(URL).buildUpon()
                .appendQueryParameter(QUERY, postalCode)
                .appendQueryParameter(MODE, mode)
                .appendQueryParameter(UNITS, unit)
                .appendQueryParameter(CNT, days)
                .build();
        String url = builtUri.toString();
        Log.v(LOG_TAG, url);
        return url;
    }
}
