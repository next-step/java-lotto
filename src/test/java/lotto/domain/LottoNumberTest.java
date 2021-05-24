package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또번호는 1~45사이 숫자여야한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void createInvalidLottoNumber(int number) {
        assertThatThrownBy(() -> LottoNumber.create(number))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 번호의 순서비교 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,-1", "2,1,1", "1,1,0"}, delimiter = ',')
    public void compareTest(int number1, int number2, int expectedNumber) {
        LottoNumber lottoNumber1 = LottoNumber.create(number1);
        LottoNumber lottoNumber2 = LottoNumber.create(number2);

        assertThat(lottoNumber1.compareTo(lottoNumber2)).isEqualTo(expectedNumber);
    }

}
