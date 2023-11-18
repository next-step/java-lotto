package lotto.domain;

import lotto.exceptions.InvalidLottoAmountException;
import lotto.exceptions.InvalidLottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    @DisplayName("로또 금액의 배수가 아닌 값을 입력하면 InvalidLottoAmountException 예외를 던진다.")
    void invalid_amount() {
        assertThatThrownBy(() -> Validator.validateAmount(13200))
                .isInstanceOf(InvalidLottoAmountException.class);
    }

    @Test
    @DisplayName("로또 금액으로 입수를 입력하면 InvalidLottoAmountException 예외를 던진다.")
    void invalid_negative_amount() {
        assertThatThrownBy(() -> Validator.validateAmount(-1000))
                .isInstanceOf(InvalidLottoAmountException.class);
    }

    @Test
    @DisplayName("입력된 로또번호의 형식이 맞지 않으면 InvalidLottoNumbersException 예외를 던진다.")
    void invalid_lotto_pattern() {
        assertThatThrownBy(() -> Validator.validateLottoNumbers(List.of(1, 2, 3)))
                .isInstanceOf(InvalidLottoNumbersException.class);
    }
}
