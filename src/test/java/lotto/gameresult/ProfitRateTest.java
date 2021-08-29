package lotto.gameresult;

import lotto.game.Payments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수익률은")
class ProfitRateTest {

    @ParameterizedTest(name = "상금 {0}원, 티켓 구매금 {1}원 일 때: {2}")
    @CsvSource(value = {"2000:1000:2.00", "2000:2000:1.00", "2000:4000:0.50"}, delimiter = ':')
    void create(int prizeMoney, int payments, double profitRate) {
        assertThat(new ProfitRate(prizeMoney, new Payments(payments)).value()).isEqualTo(profitRate);
    }
}
