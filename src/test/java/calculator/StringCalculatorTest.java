package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {

    private StringCalculator cal;

    @BeforeAll
    public void init() {
        cal = new StringCalculator();
    }

    @Test
    @DisplayName("문자열 더하기 테스트")
    void add_test() {
       assertAll(
               () -> assertEquals(1, cal.add("1")),
               () -> assertEquals(5, cal.add("2,3")),
               () -> assertEquals(15, cal.add("4,5:6")),
               () -> assertEquals(24, cal.add("//;\n7;8;9")),
               () -> assertEquals(0, cal.add(null)),
               () -> assertEquals(0, cal.add(""))
               );
    }

}