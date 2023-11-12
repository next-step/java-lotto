package src;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1500:1", "5110:5", "15450:15"}, delimiter = ':')
    void 금액에_따라_로또를_발급할_수_있다(int inputMoney, int expectedCount) {
        // when
        Money money = new Money(inputMoney);
        Lotto lotto = money.buyLotto();

        // then
        assertThat(lotto.gameCount()).isEqualTo(expectedCount);
    }
}
