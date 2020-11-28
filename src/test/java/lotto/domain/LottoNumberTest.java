package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("번호와 일치하는지 여부를 matcher 로 확인 할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "5:true"}, delimiterString = ":")
    void match(int number, boolean expected){
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.getNumberMatcher().match(new LottoNumber(5))).isEqualTo(expected);
    }

}