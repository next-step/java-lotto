package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("Rank 상수별로 count를 받아 총 상금을 리턴")
    @Test
    void getTotalPrizeByCount() {
        // given & when
        BigDecimal firstRanksTotalPrize = Rank.FIRST.getTotalPrizeByCount(1);
        BigDecimal secondRanksTotalPrize = Rank.SECOND.getTotalPrizeByCount(3);

        // then
        assertThat(firstRanksTotalPrize).isEqualTo(BigDecimal.valueOf(2_000_000_000L));
        assertThat(secondRanksTotalPrize).isEqualTo(BigDecimal.valueOf(90_000_000L));
    }
}