package observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: nautilis
 **/
public class GWeather extends Observable<GWeather, Race, WeatherType > {

    private static final Logger LOGGER = LoggerFactory.getLogger(GWeather.class);
    private WeatherType currentWeather;

    public GWeather() {
        this.currentWeather = WeatherType.SUNNY;
    }

    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        LOGGER.info("The weather changed to {}.", currentWeather);
        notifyObservers(currentWeather);
    }
}
