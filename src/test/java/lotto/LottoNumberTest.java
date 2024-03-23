package lotto;

import lotto.domain.LottoNumber;
import lotto.exception.IllegalLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    @DisplayName("[성공] 1~45 사이의 정수를 전달하면 로또 번호가 생성된다.")
    void 로또_번호() {
        assertThatCode(() -> {
            LottoNumber.of(23);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[성공][경계값] 1을 전달하면 로또 번호가 생성된다.")
    void 로또_번호_경계값_1전달() {
        assertThatCode(() -> {
            LottoNumber.of(1);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[성공][경계값] 45를 전달하면 로또 번호가 생성된다.")
    void 로또_번호_경계값_45전달() {
        assertThatCode(() -> {
            LottoNumber.of(45);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[실패][경계값] 0를 전달하면 IllegalLottoNumberException 예외가 발생한다.")
    void 로또_번호_경계값_0전달() {
        assertThatExceptionOfType(IllegalLottoNumberException.class)
                .isThrownBy(() -> LottoNumber.of(0));
    }

    @Test
    @DisplayName("[실패][경계값] 46를 전달하면 IllegalLottoNumberException 예외가 발생한다.")
    void 로또_번호_경계값_46전달() {
        assertThatExceptionOfType(IllegalLottoNumberException.class)
                .isThrownBy(() -> LottoNumber.of(46));
    }
}
