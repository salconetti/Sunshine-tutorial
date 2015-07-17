package salcon.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Javier on 17/07/2015.
 */
public class WeatherDataParser {

    public static final String LIST_DAYS = "list";
    public static final String TEMPERATURES = "temp";
    public static final String TEMP_MAX = "max";

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static Double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
    throws JSONException {

        JSONObject jsonObject = new JSONObject(weatherJsonStr);
        JSONArray jsonDays = jsonObject.getJSONArray(LIST_DAYS);
        JSONObject jsonDay = jsonDays.getJSONObject(dayIndex);
        JSONObject jsonTemperatures = jsonDay.getJSONObject(TEMPERATURES);
        Double temperatureMax = jsonTemperatures.getDouble(TEMP_MAX);

        return temperatureMax;
    }
}
