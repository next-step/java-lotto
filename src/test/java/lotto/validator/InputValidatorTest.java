package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    @DisplayName("구매 금액을 빈값 또는 null로 입력한 경우 IllegalArgumentException이 발생한다.")
    void 구매금액_빈값_또는_null() {
        InputValidator inputValidator = new InputValidator();

        Assertions.assertThatThrownBy(() -> {
            inputValidator.validate(" ");
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            inputValidator.validate(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액을 문자 또는 음수로 입력한 경우 IllegalArgumentException이 발생한다.")
    void 구매금액_문자_또는_음수() {
        InputValidator inputValidator = new InputValidator();

        Assertions.assertThatThrownBy(() -> {
            inputValidator.validate("AASSDD");
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            inputValidator.validate("-5000");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
