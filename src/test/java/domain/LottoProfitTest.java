package domain;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

public class LottoProfitTest {
    @Test
    void getProfitRateTDD() {
        BigDecimal bd1 = new BigDecimal(100);
        BigDecimal bd2 = new BigDecimal(2000);
        BigDecimal result = bd1.divide(bd2);

        System.out.println(result.setScale(2));
    }

}
