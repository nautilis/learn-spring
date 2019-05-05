#### 抽象工厂方法

##### 概念
- 产品族，是指由一个工厂生产的位于不同产品等级结构中的一组产品。例如不同的王国有不同的城堡，军队和国王。城堡，军队和国王就是王国工厂的产品族。
- 抽象工厂方法，提供一个接口用于创造生产不同产品族的工厂。例如精灵王国有精灵城堡，精灵军队和精灵国王，而兽人反之。

##### 代码实现
- 首先我们有一组产品（国王，城堡和军队）的接口，以及它们的实现类。
```java
public interface Army {
    String getDescription();
}
public interface Castle {
    String getDescription();   
}
public interface King {
    String getDescription();
}
public class ElfArmy implements Army {

    static final String DESC = "This is Elven army";

    @Override
    public String getDescription() {
        return DESC;
    }
}
public class ElfCastle implements Castle {

    static final String DESC = "This is Elven castle";

    @Override
    public String getDescription() {
        return DESC;
    }
}
public class ElfKing implements King {

    static final String DESC = "This is the Elven king";

    @Override
    public String getDescription() {
        return DESC;
    }
}
//......orc 同样

```
- 然后有一个王国工厂的抽象以及精灵跟兽人各自的实现。
```java
public interface KingdomFactory {

    Castle createCastle();
    
    King createKing();
    
    Army createArmy();

}
public class ElfKingdomFactory implements KingdomFactory {


    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
```
- 现在我们就拥有了抽象工厂来获取同一产品族的产品, 即是精灵王国工厂创建精灵国王，精灵军队和精灵城堡。
```java
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
```