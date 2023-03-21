package lotto.model;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void getNumber() throws IllegalAccessException {
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getNumber()).isGreaterThan(0).isLessThan(46);
    }

    @Test
    void validate() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber());
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber());
    }
}