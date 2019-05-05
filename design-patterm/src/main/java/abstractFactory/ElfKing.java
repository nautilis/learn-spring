package abstractFactory;

/**
 * @author: nautilis
 **/
public class ElfKing implements King {

    static final String DESC = "This is the Elven king";

    @Override
    public String getDescription() {
        return DESC;
    }
}
