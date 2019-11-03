package step2.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 로또번호생성() {
        int number = 1;
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "46"})
    void name(Integer invalidNumber) {
        assertThatThrownBy(() -> new LottoNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidNumber + "는 올바른 로또번호가 아닙니다.");
    }
}