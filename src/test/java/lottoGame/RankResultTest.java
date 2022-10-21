package lottoGame;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankResultTest {
    private final List<Rank> matches = List.of(Rank.FIFTH);

    @Test
    void getYield() {
        RankResult rankResult = new RankResult();
        rankResult.putResult(matches);
        BigDecimal bigDecimal = new BigDecimal("0.35");
        assertEquals(0, rankResult.getYield(14000.0).compareTo(bigDecimal));
    }

}