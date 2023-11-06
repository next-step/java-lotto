package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class OperationValidatorTest {

    @ParameterizedTest(name = "입력값이 {0} 이면 IllegalArgumentException이 발생한다")
    @NullAndEmptySource
    void 입력값_검증_테스트(String actual) {
        assertThrows(IllegalArgumentException.class, () -> OperationValidator.valid(actual));
    }

    @ParameterizedTest(name = "입력값이 숫자 혹은 사칙연산이 아니면 IllegalArgumentException이 발생한다")
    @ValueSource(strings = {"!", "@", "#", "$", "a"})
    void 입력값_검증_테스트2(String actual) {
        assertThrows(IllegalArgumentException.class, () -> OperationValidator.valid(actual));
    }

    @ParameterizedTest(name = "입력값이 사칙연산 {0} 이면 통과한다")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 입력값_검증_테스트3(String actual) {
        assertDoesNotThrow(() -> OperationValidator.valid(actual));
    }

    @ParameterizedTest(name = "입력값이 숫자면 통과한다")
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 입력값_검증_테스트4(String actual) {
        assertDoesNotThrow(() -> OperationValidator.valid(actual));
    }

}
