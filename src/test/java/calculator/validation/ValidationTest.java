package calculator.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @Test
    @DisplayName("문자열이 아니면 에러 발생")
    void 숫자확인() {
        String text = "A";
        assertThatThrownBy(() -> Validation.checkNumber(text))
                .isInstanceOf(NumberFormatException.class);

    }

    @Test
    @DisplayName("문자열이 사칙연산이 아니면 에러 발생")
    void 사칙연산_확인() {
        String text = "&";
        assertThatThrownBy(() -> Validation.checkFourBasicOperation(text))
                .isInstanceOf(InputMismatchException.class);
    }
}
