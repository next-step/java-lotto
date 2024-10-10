import controller.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.Preprocessor;
import view.Input;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("입력값 null or ''")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void inputForNullAndEmpty(String value) {
        Preprocessor preprocessor = new Preprocessor();
        boolean isEmpty = preprocessor.verificationOfInputValue(value);
        assertFalse(isEmpty);
    }

    @Test
    @DisplayName("계산기 최종 결과값 출력")
    public void calculateResult() {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
