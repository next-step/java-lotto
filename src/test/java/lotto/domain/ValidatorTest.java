package lotto.domain;

import lotto.exceptions.InvalidLottoAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
