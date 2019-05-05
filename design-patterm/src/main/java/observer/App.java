package observer;

/**
 * @author: nautilis
 **/
public class App {

    public static void main(String[] args) {
        GWeather weather = new GWeather();
        weather.addObserver(new GOrcs());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
    }

}
