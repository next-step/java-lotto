package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

    @ParameterizedTest(name = "입력값이 {0} 이면 IllegalArgumentException이 발생한다")
    @NullAndEmptySource
    void 입력값_검증_테스트(String actual) {
        assertThrows(IllegalArgumentException.class, () -> new StringCalculator(actual));
    }

}
