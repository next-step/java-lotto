package lotto.domain.number;

import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    private static final int FIRST_NUMBER = 1;
    private static final int LAST_NUMBER = 45;
    private static final String ERROR_OUT_OF_SCOPE_MESSAGE
            = "로또 숫자의 범위는 " + FIRST_NUMBER + "부터 " + LAST_NUMBER + " 사이입니다.";

    @DisplayName("유효한 범위의 숫자로 로또 번호 객체를 생성할 수 있다.")
    @Test
    void createValidLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.of(10);
        assertThat(lottoNumber.toString())
                .isEqualTo("10");
    }

    @DisplayName("유효하지 않은 범위의 숫자를 입력하면 예외가 발생한다.")
    @Test
    void throwExceptionWhenLottoNumberOutOfRange() {
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(ERROR_OUT_OF_SCOPE_MESSAGE);

        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessage(ERROR_OUT_OF_SCOPE_MESSAGE);
    }

    @DisplayName("다른 객체라도 로또 번호가 같으면 두 객체는 동일하다.")
    @Test
    void testLottoNumberEquality() {
        LottoNumber lottoNumber1 = LottoNumber.of(5);
        LottoNumber lottoNumber2 = LottoNumber.of(5);
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }

}
