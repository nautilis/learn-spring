package observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: nautilis
 **/
public class GOrcs implements Race {

    private static final Logger LOGGER = LoggerFactory.getLogger(GOrcs.class);

    @Override
    public void update(GWeather gWeather, WeatherType weatherType) {
          switch (weatherType) {
              case CLOUD:
                 LOGGER.info("he orcs are freezing cold.");
                 break;
              case RAINY:
                 LOGGER.info("he orcs are freezing cold.");
                 break;
              case SUNNY:
                  LOGGER.info("The sun hurts the orcs' eyes.");
                  break;
              case WINDY:
                  LOGGER.info("The orc smell almost vanishes in the wind");
                  break;
              default:
                  break;

          }
    }
}
