package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoCountTest {

    @ParameterizedTest
    @ValueSource(ints= {1_000, 14_000, 999_000})
    void 금액에_따른_로또_개수를_출력한다(int value) {
        LottoCount lottoCount = new LottoCount(value);
        assertThat(value / 1000).isEqualTo(lottoCount.count());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 900})
    void 구매할_수_없는_금액을_입력한_경우_예외를_발생시킨다(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoCount(value));
    }
}
