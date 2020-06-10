package lottoTest;

import lotto.model.LottoStatic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

}
