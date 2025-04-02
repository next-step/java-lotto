package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("유효하지 않은 로또 번호 생성")
    @ValueSource(ints = {-1,0,46,100})
    void 유효하지_않은_로또_번호_생성(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효하지 않은 로또 번호입니다");

    }

    @ParameterizedTest
    @DisplayName("로또 번호 생성")
    @CsvSource(value = {"1:1","11:11","21:21","45:45"}, delimiter = ':')
    void 로또_번호_생성(int input, int expect) {

        LottoNumber lottoNumber = new LottoNumber(input);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(expect));

    }

}
