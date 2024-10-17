package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @Test
    @DisplayName("우승자 통계 테스트")
    void 우승자_통계_테스트() {
        Assertions.assertThat(Prize.calculateStatistic(2_000_005_000).values()
        ).containsExactly(1,0,0,1);
    }

}
