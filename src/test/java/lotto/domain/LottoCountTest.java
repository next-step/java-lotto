package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1_000, 14_000, 999_000})
    void 금액에_따른_로또_개수를_출력한다(int value) {
        Money money = new Money(String.valueOf(value));
        LottoCount lottoCount = LottoCount.from(money);
        assertThat(lottoCount.count()).isEqualTo(value / 1000);
    }
}
