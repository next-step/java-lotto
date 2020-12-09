package textAddCalculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationCheckerTest {

    @Test
    @DisplayName("빈문자열 입력 test")
    void emptyStringTest() {
        String empty = "";
        assertThat(ValidationChecker.isEmptyOrNull(empty)).isEqualTo(true);
    }

    @Test
    @DisplayName("NULL 입력 test")
    void nullTest() {
        String nullStr = null;
        assertThat(ValidationChecker.isEmptyOrNull(nullStr)).isEqualTo(true);
    }

    @Test
    @DisplayName("음수 test")
    void minusNumberTest() {
        String[] minusNum = new String[] {"-3"};
        assertThatThrownBy(() -> ValidationChecker.exceptionCheck(minusNum))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("문자 test")
    void characterTest() {
        String[] character = new String[] {"f"};
        assertThatThrownBy(() -> ValidationChecker.exceptionCheck(character))
                .isInstanceOf(RuntimeException.class);
    }
}
