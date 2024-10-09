package step3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 로또 숫자를 생성한다.
- 로또 숫자를 확인한다.
*/
public class LottoNumberTest {

    @DisplayName("1~45 사이에 로또 숫자를 생성한다.")
    @Test
    void createNumberTest() {
        LottoNumber lottoNumber = new LottoNumber();

        assertThat(lottoNumber.getNumber()).isBetween(1,45);
    }

    @DisplayName("로또 숫자를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void confirmLottoNumTest(int num, boolean expected) {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber.confirmLottoNum(num)).isEqualTo(expected);
    }
}
