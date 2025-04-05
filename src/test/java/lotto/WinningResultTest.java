package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.domain.MatchCount;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("WinningResult 는 당첨 번호와 로또 번호의 일치 개수에 따라 로또 개수를 기록한다")
    @Test
    void addAndCountByMatch() {
        WinningResult result = new WinningResult();

        result.add(MatchCount.of(3));
        result.add(MatchCount.of(3));
        result.add(MatchCount.of(4));

        assertThat(result.countByMatch(MatchCount.THREE)).isEqualTo(2);
        assertThat(result.countByMatch(MatchCount.FOUR)).isEqualTo(1);
        assertThat(result.countByMatch(MatchCount.FIVE)).isZero();
    }

    @DisplayName("WinningResult 는 수익률을 계산할 수 있다.")
    @Nested
    class calculate {

        @DisplayName("수익률이 0 이상으로 난 경우에 대해 계산할 수 있다.")
        @Test
        void calculateProfitRateOverZero() {
            WinningResult result = new WinningResult();

            result.add(MatchCount.of(3));
            result.add(MatchCount.of(3));
            result.add(MatchCount.of(4));
            result.add(MatchCount.of(6));

            assertThat(result.calculateProfitRate(4000)).isEqualTo(new BigDecimal("500015.00"));
        }

        @DisplayName("수익률이 0 이하로 난 경우에 대해 계산할 수 있다.")
        @Test
        void calculateProfitRateUnderZero() {
            WinningResult result = new WinningResult();

            result.add(MatchCount.of(0));
            result.add(MatchCount.of(0));
            result.add(MatchCount.of(0));
            result.add(MatchCount.of(1));
            result.add(MatchCount.of(2));
            result.add(MatchCount.of(2));
            result.add(MatchCount.of(3));

            assertThat(result.calculateProfitRate(7000)).isEqualTo(new BigDecimal("0.71"));
        }
    }
}
