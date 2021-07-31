package calculators;

import calculators.vo.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTest {

    @Test
    @DisplayName("0이거나 정수면 정상 생성")
    void positiveNumberAndZero() {
        final String input = "1";
        assertDoesNotThrow(() -> {
            Number number = Number.from(input);
            assertEquals(number.getValue(), Integer.parseInt(input));
        });
    }

    @Test
    @DisplayName("음수면 Runtime 에러")
    void negativeNumber() {
        final String input = "-1";
        assertThrows(RuntimeException.class, () -> {
            Number.from(input);
        });
    }

    @Test
    @DisplayName("문자면 Runtime 에러")
    void character() {
        final String input = "a";
        assertThrows(RuntimeException.class, () -> {
            Number.from(input);
        });
    }
}
