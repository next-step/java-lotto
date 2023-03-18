package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {

    @DisplayName("숫자만으로 이루어진 목록 입력")
    @Test
    void validOperandTest() {
        List<String> parsingText = Arrays.asList("1", "3", "6");
        Operand operand = new Operand(parsingText);

        List<Integer> actuals = operand.getOperands();
        assertTrue(actuals.contains(1));
        assertTrue(actuals.contains(3));
        assertTrue(actuals.contains(6));
    }

    @DisplayName("일부 문자가 포함된 목록 입력")
    @Test
    void invalidOperandTest() {
        List<String> parsingText = Arrays.asList("1", "a", "6");
        assertThrows(RuntimeException.class, () -> {
            new Operand(parsingText);
        });
    }

    @DisplayName("음수가 포함된 목록 입력")
    @Test
    void negativeInvalidOperandTest() {
        List<String> parsingText = Arrays.asList("1", "9", "-6");
        assertThrows(RuntimeException.class, () -> {
            new Operand(parsingText);
        });
    }

}