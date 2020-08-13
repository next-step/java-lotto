package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @Test
    @DisplayName("문자열 더하기 테스트")
    void add_test() {
       assertAll(
               () -> assertEquals(1, StringCalculator.add("1")),
               () -> assertEquals(5, StringCalculator.add("2,3")),
               () -> assertEquals(15, StringCalculator.add("4,5:6")),
               () -> assertEquals(24, StringCalculator.add("//;\n7;8;9"))
               );
    }

}