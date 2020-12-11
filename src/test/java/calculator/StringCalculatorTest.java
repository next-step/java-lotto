package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열 더하기 테스트")
    void add_test() {
        assertAll(
                () -> assertEquals(0, stringCalculator.add(null)),
                () -> assertEquals(0, stringCalculator.add("")),
                () -> assertEquals(1, stringCalculator.add("1")),
                () -> assertEquals(5, stringCalculator.add("2,3")),
                () -> assertEquals(15, stringCalculator.add("4,5:6")),
                () -> assertEquals(24, stringCalculator.add("//;\n7;8;9"))
        );
    }

}
