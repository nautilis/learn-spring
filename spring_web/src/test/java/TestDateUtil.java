import org.assertj.core.util.DateUtil;

/**
 * @author: zpf
 **/
public class TestDateUtil {

    public static void main(String[] args) {
        String channel = "0,3,9,8";
        String wrong1 = "0,3,9,";
        String wrong2 = "0,3,10,11";
        String right1 = "0";

        System.out.println(channel.matches("([0-9],){0,9}[0-9]$"));

    }


}
