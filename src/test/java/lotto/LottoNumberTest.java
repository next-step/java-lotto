package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void value() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.value()).isEqualTo(1);
    }

    @Test
    void compareTo() {
        LottoNumber small = new LottoNumber(1);
        LottoNumber big = new LottoNumber(10);
        assertThat(small.compareTo(big)).isEqualTo(small.value() - big.value());
    }

    @Test
    void testToString() {
        LottoNumber stringLotto = new LottoNumber(1);
        assertThat(stringLotto.toString()).isEqualTo("1");
    }

    @Test
    void testValidate() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            new LottoNumber(-1);
        });
    }
}