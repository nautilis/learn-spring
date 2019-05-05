package strategy;

/**
 * @author: nautilis
 **/
public class DragonSlayer {

    private DragonSlayingStrategy strategy;

    public DragonSlayer(DragonSlayingStrategy slayingStrategy) {
        this.strategy = slayingStrategy;
    }

    public void changeStrategy(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }

    public void goToBattle() {
        strategy.execute();
    }

}
