package lottoTest;

import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    LottoStatistics lottoStatistics = new LottoStatistics();

    @DisplayName("몇 장의 로또를 구입할 수 있을지 알려준다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2", "500, 0", "1440, 1", "0, 0"})
    public void howManyLottoTest(int budget, int expected) {
        int purchase = lottoStatistics.buyLottos(budget);
        assertThat(purchase).isEqualTo(expected);
    }

    @DisplayName("당첨된 번호 갯수를 가지고 당첨 금액을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"FIRST, 2000000000", "SECOND, 30000000", "THIRD, 1500000", "FOURTH, 50000", "FIFTH, 5000", "MISS, 0"})
    public void takePrizeMoney(Rank rank, int prize) {
        int money = lottoStatistics.getPrizeMoney(rank);
        assertThat(money).isEqualTo(prize);
    }

    @DisplayName("당첨된 번호 갯수를 가지고 당첨 금액을 반환한다")
    @ParameterizedTest
    @NullSource
    public void takePrizeMoneyNulll(Rank rank) {
        int money = lottoStatistics.getPrizeMoney(rank);
        assertThat(money).isEqualTo(0);
    }

    @DisplayName("구입 금액을 받아 수익률을 계산한다")
    @ParameterizedTest
    @CsvSource(value = {"5000, 14000, 0.35", "100, 100, 1", "100, 1000, 0.1", "1000, 100, 10"})
    public void calcProfit(int prize, int budget, double expected) {
        double profits = lottoStatistics.calcProfit(prize, budget);
        assertThat(profits).isEqualTo(expected);
    }
}
