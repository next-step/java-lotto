package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankMapTest {

    @Test
    void test() {
        RankMap rankMap = new RankMap(List.of(
                new MatchedCount(5),
                new MatchedCount(5, true)
        ));
        Prizes allPrizes = rankMap.getAllPrizes();
        assertThat(rankMap.getAllPrizes()).isEqualTo(new Prizes(List.of(new Money(30000000), new Money(1500000))));
    }
}