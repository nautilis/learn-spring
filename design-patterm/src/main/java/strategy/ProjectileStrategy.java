package strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: nautilis
 **/
public class ProjectileStrategy implements DragonSlayingStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectileStrategy.class);

    @Override
    public void execute() {
        LOGGER.info("You shoot the dragon with magical crossbow and it dead on the ground!");
    }
}
