package dev.solar.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @Test
    void 생성_및_동일한_값() {
        final LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(LottoNumber.of("1")).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위를_벗어나는_값(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }
}
