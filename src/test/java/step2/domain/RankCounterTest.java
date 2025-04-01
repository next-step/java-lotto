package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.rank.RankCounter;
import step2.domain.rank.RankType;

public class RankCounterTest {

    @DisplayName("당첨 횟수 증가")
    @Test
    void increaseCountTest() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.increaseCount(RankType.FIRST);

        Assertions.assertThat(rankCounter.getCount(RankType.FIRST)).isEqualTo(1);
    }
}
