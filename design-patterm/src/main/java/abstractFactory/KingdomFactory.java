package abstractFactory;

/**
 * @author: nautilis
 **/
public interface KingdomFactory {

    Castle createCastle();

    King createKing();

    Army createArmy();

}
