package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoCountTest {

    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "14000, 14", "999000, 999"})
    void 금액에_따른_로또_개수를_출력한다(int value, int count) {
        Money money = new Money(String.valueOf(value));
        LottoCount lottoCount = LottoCount.from(money);
        assertThat(lottoCount.count()).isEqualTo(count);
    }
}
