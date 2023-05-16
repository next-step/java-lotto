package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

public class InputStringTest {

    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자이면 예외처리")
    @ParameterizedTest(name = "{displayName} {index} = 입력: {0}")
    void inputStringNullOrEmptyTest(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> new InputString(inputString));
    }

    @Test
    @DisplayName("입력값이 올바르지 않으면 예외처리")
    void inputStringNotValidationTest() {
        String inputString = "2 + 3 * 4 / 2 % 2";
        assertThatIllegalArgumentException().isThrownBy(() -> new InputString(inputString));
    }


    @Test
    @DisplayName("입력값이 올바른 형태인지 체크")
    void inputStringValidationTest() {
        String inputString = "2 + 3 * 4 / 2";
        assertThatNoException().isThrownBy(() -> new InputString(inputString));
    }

}
