package common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: nautilis
 **/
@Slf4j
public class TestSteam {

    @Test
    public void testMap() {
        List<Integer> nums = new ArrayList<>();
        nums.add(123); nums.add(245);
        double sum = nums.stream().mapToDouble(n -> n).sum();
        System.out.println(sum);
    }

}
