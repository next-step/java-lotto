package lotto;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("숫자로 만들어진다.")
    @ValueSource(ints = {1, 2, 24, 33, 43, 44, 45})
    @ParameterizedTest
    void doesNotThrowAnyExceptionWhenCreateCorrectly(int number) {
        assertThatNoException().isThrownBy(()-> LottoNumber.from(number));
    }

    @DisplayName("46 이상의 숫자는 만들 수 없다.")
    @Test
    void throwIllegalArgumentExceptionWhenOver46() {
        assertThatThrownBy(()-> LottoNumber.from(46));
    }

    @DisplayName("0 이하의 숫자는 만들 수 없다.")
    @Test
    void throwIllegalArgumentExceptionWhenUnder0() {
        assertThatThrownBy(()-> LottoNumber.from(0));
    }

    @DisplayName("인자와 값을 비교한다.")
    @CsvSource(value = {"33,true", "21,false"})
    @ParameterizedTest
    void compareNumber(int compareInteger, boolean expected) {
        LottoNumber lottoNumber = LottoNumber.from(33);
        Assertions.assertThat(lottoNumber.compare(compareInteger)).isEqualTo(expected);
    }
}
