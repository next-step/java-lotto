package lottoGame;

import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class RankResultTest {
    private final List<Integer> matches = List.of(3);

    @Test
    void getYield() {
        RankResult rankResult = new RankResult();
        rankResult.putResult(matches);
        BigDecimal bigDecimal = new BigDecimal("0.35");
        assertEquals(0,rankResult.getYield(14000.0).compareTo(bigDecimal));
    }
}