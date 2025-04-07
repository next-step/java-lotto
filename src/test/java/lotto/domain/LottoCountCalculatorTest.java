package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCountCalculatorTest {

    @DisplayName("금액에 따른 로또 갯수를 계산한다.")
    @ParameterizedTest
    @CsvSource({
            "900, 0",
            "1000, 1",
            "3000, 3",
            "15400, 15",
            "30200, 30",
            "50000, 50"
    })
    void calculateLottoCount(int amount, int expected) {
        Amount amount1 = new Amount(amount);
        assertThat(amount1.calculateLottoCount(amount)).isEqualTo(expected);
    }
}
