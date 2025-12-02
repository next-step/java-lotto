package controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void 빈_문자열_null_체크(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Calculator(input);
        });
    }
}
