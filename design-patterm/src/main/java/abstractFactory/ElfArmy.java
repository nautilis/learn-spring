package abstractFactory;

/**
 * @author: nautilis
 **/
public class ElfArmy implements Army {

    static final String DESC = "This is Elven army";

    @Override
    public String getDescription() {
        return DESC;
    }
}
