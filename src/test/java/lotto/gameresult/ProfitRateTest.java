package lotto.gameresult;

import lotto.game.Payments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수익률은")
class ProfitRateTest {

    @DisplayName("상금")
    @ParameterizedTest(name = "{0}원, 티켓 구매금 {1}원 일 때: {2}")
    @CsvSource(value = {"2000:1000:2.00", "2000:2000:1.00", "2000:4000:0.50"}, delimiter = ':')
    void create(int prizeMoney, int payments, double profitRate) {
        assertThat(new ProfitRate(prizeMoney, new Payments(payments)).value()).isEqualTo(profitRate);
    }

    @DisplayName("손익분기점보다 크다")
    @Test
    void isGreaterThan() {
        assertThat(new ProfitRate(11, 10).isGreaterthan(Gain.BREAK_EVEN_POINT_PROFIT_RATE)).isTrue();
    }

    @DisplayName("손익분기점보다 작다")
    @Test
    void isLessThan() {
        assertThat(new ProfitRate(9, 10).isLessthan(Gain.BREAK_EVEN_POINT_PROFIT_RATE)).isTrue();
    }
}
