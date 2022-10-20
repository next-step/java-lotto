package lottoGame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankResultTest {
    private final List<Integer> matches = List.of(3,3,4);

    @Test
    void getYield() {
        RankResult rankResult = new RankResult();
        rankResult.putResult(matches);
        assertThat(rankResult.getYield(10000)).isEqualTo("6.00");
    }
}