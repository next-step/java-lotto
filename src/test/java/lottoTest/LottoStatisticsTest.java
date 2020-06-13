package lottoTest;

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
    @CsvSource(value = {"1, 2000000000", "2, 1500000", "3, 50000", "4, 5000", "5, 0"})
    public void getPrizeMoney(int rank, int prize) {
        int money = lottoStatic.getPrizeMoney(rank);
        assertThat(money).isEqualTo(prize);
    }
}
