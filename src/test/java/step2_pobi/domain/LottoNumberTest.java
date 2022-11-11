package step2_pobi.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.of("1");
        assertThat(LottoNumber.of(1)).isEqualTo(lottoNumber);
        assertThat(LottoNumber.of(1) == lottoNumber).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위를_벗어나는_값(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(value));
    }
}