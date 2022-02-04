package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankResultTest {

    private static final int total = 264500000;

    @DisplayName("로또_등수를_합친_상금_테스트")
    @Test
    void totalPrizeTest() {
        HashMap<Rank, Integer> hashmap = new HashMap<Rank, Integer>();

        hashmap.put(Rank.FIRST, 1);
        hashmap.put(Rank.SECOND, 2);
        hashmap.put(Rank.THIRD, 3);

        RankResult rankResult = new RankResult(hashmap);
        assertThat(rankResult.getTotalPrize().getValue()).isEqualTo(total);
    }
}
