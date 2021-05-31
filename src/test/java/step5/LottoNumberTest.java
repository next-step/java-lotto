package step5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.LottoNumber;
import step5.exception.InValidLottoNumberException;

import static org.assertj.core.api.Assertions.*;


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
        assertThatThrownBy(() -> {
            LottoNumber.of(value);
        }).isInstanceOf(InValidLottoNumberException.class);
    }
}