package domain;

import domain.lotto.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCounterTest {

    @DisplayName("당첨 횟수 증가")
    @Test
    void increaseCountTest() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.increaseCount(Rank.FIRST);

        Assertions.assertThat(rankCounter.getCount(Rank.FIRST)).isEqualTo(1);
    }
}
