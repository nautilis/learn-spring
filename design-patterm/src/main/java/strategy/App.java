package strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: nautilis
 **/
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOGGER.info("Green dragon spotted ahead");
        DragonSlayer slayer = new DragonSlayer(new MeleeStrategy());
        slayer.goToBattle();
        LOGGER.info("Red dragon emerges");
        slayer.changeStrategy(new ProjectileStrategy());
        slayer.goToBattle();

        //Java 8 strategy pattern
        LOGGER.info("Green dragon spotted ahead!");
        slayer = new DragonSlayer(
                () -> LOGGER.info("With your Excalibur you severe the dragon's head!"));
        slayer.goToBattle();
        //...
    }

}
