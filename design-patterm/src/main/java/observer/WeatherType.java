package observer;

/**
 * @author: nautilis
 **/
public enum WeatherType {
    SUNNY, RAINY, CLOUD, WINDY;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
