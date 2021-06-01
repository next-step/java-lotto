package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.LottoPrize.*;

class LottoPrizeTest {

    @DisplayName("종목별 당첨 횟수와 당첨 금액 합계 카운트")
    @Test
    void updateStatus() {
        FIRST.updateWinningResult(FIRST.matchCount);
        int totalWinningCount = FIRST.getWinningCount();
        long totalWinningPrize = FIRST.getWinningPrize();
        assertThat(totalWinningCount).isEqualTo(1);
        assertThat(totalWinningPrize).isEqualTo(FIRST.matchPrize);
    }

    @DisplayName("로또 번호 일치 갯수에 따라 당첨 종류 구하기")
    @Test
    void findByMatchingCount() {
        for (LottoPrize prize : values()) {
            LottoPrize result = findByMatchCount(prize.matchCount);
            assertThat(result).isEqualTo(prize);
        }
    }

}