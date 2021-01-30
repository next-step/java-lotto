package stringadder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @DisplayName("적절한 숫자 문자이 들어오면 정수형으로 변환")
    @Test
    void toIntWithProperNumber() {
        assertEquals(1, Converter.toInt("1"));
    }

    @DisplayName("0보다 작은 숫자가 들어오면 Exception 발생")
    @Test
    void toIntWithMinusNumber() {
        assertThrows(RuntimeException.class, () -> {
            Converter.toInt("-1");
        });
    }

    @DisplayName("숫자가 아닌 문자열이 들어오면 Exception 발생")
    @Test
    void toIntWithNotNumber() {
        assertThrows(RuntimeException.class, () -> {
            Converter.toInt("S");
        });
    }
}