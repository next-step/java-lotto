package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankMapTest {

    @Test
    void get_prizes_by_rank() {
        RankMap rankMap = new RankMap(List.of(
                new MatchedCount(5),
                new MatchedCount(5, true)
        ));

        assertThat(rankMap.getAllPrizes())
                .isEqualTo(new Prizes(List.of(new Money(30000000), new Money(1500000))));
    }
}