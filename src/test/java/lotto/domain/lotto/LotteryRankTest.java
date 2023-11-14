package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LotteryRankTest {

    @DisplayName("로또 등수와 등수 별 개수를 인자로 받아 획득 상금을 계산한다.")
    @Test
    void calculatePrize() {
        // given
        LotteryRank rank = LotteryRank.THIRD;
        long count = 2;

        // when
        long prize = LotteryRank.calculatePrize(rank, count);

        // then
        assertThat(prize).isEqualTo(100000);
    }
}