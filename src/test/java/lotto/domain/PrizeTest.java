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

    @Test
    @DisplayName("수익률 계산 테스트")
    void 수익률_계산_테스트() {

        Assertions.assertThat(Prize.calculateProfit(5000,14000)).isEqualTo(0.35);

    }

}
