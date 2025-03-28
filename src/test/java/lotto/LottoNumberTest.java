package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 40, 45})
    @DisplayName("로또 번호는 1~45 사이의 숫자면 정상적으로 생성된다")
    void ofSuccess(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        Assertions.assertThat(lottoNumber).isEqualTo(LottoNumber.of(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 48})
    @DisplayName("로또 번호는 1~45 사이의 숫자여야 한다.")
    void ofFail(int number) {
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(number));
    }

    @Test
    @DisplayName("로또 번호가 같으면 같은 로또 번호 객체이다")
    void equals() {
        LottoNumber lottoNumber1 = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(1);
        Assertions.assertThat(lottoNumber1).isEqualTo(lottoNumber2);

        LottoNumber lottoNumber3 = LottoNumber.of(2);
        Assertions.assertThat(lottoNumber1).isNotEqualTo(lottoNumber3);
    }


    @Test
    @DisplayName("로또 번호 객체는 크기 비교가 가능해야 한다")
    void compareTo() {
        LottoNumber lottoNumber1 = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(3);
        Assertions.assertThat(lottoNumber1.compareTo(lottoNumber2)).isLessThan(0);

        LottoNumber lottoNumber3 = LottoNumber.of(2);
        Assertions.assertThat(lottoNumber3.compareTo(lottoNumber1)).isGreaterThan(0);
    }
}
