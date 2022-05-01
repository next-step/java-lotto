package Lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"0","46"})
    @DisplayName("로또번호는 1부터 45사이 숫자만 생성 가능합니다.")
    void validateNumberTest(int lottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 1부터 45사이 숫자만 생성 가능합니다.");
    }
}
