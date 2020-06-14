package lottoTest;

import lotto.model.Lotto;
import lotto.model.LottoStatic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    LottoStatic lottoStatic = new LottoStatic();

    @DisplayName("몇 장의 로또를 구입할 수 있을지 알려준다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2", "500, 0", "1440, 1", "0, 0"})
    public void howManyLottoTest(int budget, int expected) {
        int purchase = lottoStatic.buyLottos(budget);
        assertThat(purchase).isEqualTo(expected);
    }

    @DisplayName("당첨된 번호 갯수를 가지고 당첨 금액을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"ALL_MATCH, 2000000000", "MISS_ONE, 1500000", "MISS_TWO, 50000", "MISS_THREE, 5000", "NONE, 0"})
    public void takePrizeMoney(Lotto.Rank rank, int prize) {
        int money = lottoStatic.getPrizeMoney(rank);
        assertThat(money).isEqualTo(prize);
    }

    @DisplayName("구입 금액을 받아 수익률을 계산한다")
    @ParameterizedTest
    @CsvSource(value = {"5000, 14000, 0.35", "100, 100, 1", "100, 1000, 0.1", "1000, 100, 10"})
    public void calcProfit(int prize, int budget, double expected) {
        double profits = lottoStatic.calcProfit(prize, budget);
        assertThat(profits).isEqualTo(expected);
    }
}
