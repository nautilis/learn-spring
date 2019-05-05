package abstractFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: nautilis
 **/
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private King king;
    private Castle castle;
    private Army army;

    public void createKingdom(final KingdomFactory factory) {
        setKing(factory.createKing());
        setArmy(factory.createArmy());
        setCastle(factory.createCastle());
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Castle getCastle() {
        return castle;
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public static class FactoryMaker {
        public enum KingdomType {
             ELF,
        }

        public static KingdomFactory makeFactory(KingdomType type) {
            switch (type) {
                case ELF:
                    return new ElfKingdomFactory();
                default:
                    throw new IllegalArgumentException("KingdomType not supported.");
            }
        }

    }

    public static void main(String[] args) {
        App app = new App();
        LOGGER.info("ELF Kingdom");
        app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF));
        LOGGER.info(app.getArmy().getDescription());
        LOGGER.info(app.getCastle().getDescription());
        LOGGER.info(app.getKing().getDescription());
    }
}


