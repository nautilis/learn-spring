package abstractFactory;

/**
 * @author: nautilis
 **/
public class ElfCastle implements Castle {

    static final String DESC = "This is Elven castle";

    @Override
    public String getDescription() {
        return DESC;
    }
}
