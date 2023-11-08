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
        assertThrows(IllegalArgumentException.class, () -> OperationValidator.validate(actual));
    }

    @ParameterizedTest(name = "입력값이 짝수({0})면 IllegalArgumentException이 발생한다")
    @ValueSource(strings = {"1 +", "", "1 + 2 +"})
    void 입력값_검증_테스트2(String actual) {
        assertThrows(IllegalArgumentException.class, () -> OperationValidator.validate(actual));
    }

    @ParameterizedTest(name = "입력값 갯수가 홀수({0})면 통과한다")
    @ValueSource(strings = {"1 + 2", "1 + 2 + 3"})
    void 입력값_검증_테스트3(String actual) {
        assertDoesNotThrow(() -> OperationValidator.validate(actual));
    }

    @ParameterizedTest(name = "입력값 시작과 끝이 숫자({0})가 아니면 IllegalArgumentException이 발생한다")
    @ValueSource(strings = {"1 +", "", "1 + 2 +"})
    void 입력값_검증_테스트4(String actual) {
        assertThrows(IllegalArgumentException.class, () -> OperationValidator.validate(actual));
    }

    @ParameterizedTest(name = "입력값이 (숫자)(연산자 숫자) ({0})와 같은 패턴이 아니면 IllegalArgumentException이 발생한다")
    @ValueSource(strings = {"1 + + 1", "1 1 + 1"})
    void 입력값_검증_테스트5(String actual) {
        assertThrows(IllegalArgumentException.class, () -> OperationValidator.validate(actual));
    }

    @ParameterizedTest(name ="입력값이 (숫자)(연산자 숫자) ({0})와 같은 패턴이 아니면 IllegalArgumentException이 발생한다")
    @ValueSource(strings = {"1 + 1", "1 + 1 + 2"})
    void 입력값_검증_테스트6(String actual) {
        assertDoesNotThrow(() -> OperationValidator.validate(actual));
    }

    @ParameterizedTest(name = "입력값이 (숫자)(연산자 숫자) ({0})와 같은 패턴이면 통과한다")
    @ValueSource(strings = {"1 + 1", "1 + 1 + 2"})
    void 입력값_검증_테스트7(String actual) {
        assertDoesNotThrow(() -> OperationValidator.validate(actual));
    }

}
