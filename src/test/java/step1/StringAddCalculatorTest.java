package step1;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    void stringAddCalculator() {
        int ans = StringAddCalculator.calculate("1,2:3");
        assertEquals(6, ans);
    }

    @Test
    void calculateComma() {
        int ans = StringAddCalculator.calculate("1,2,3,4");
        assertEquals(10, ans);
    }

    @Test
    void illegalArgumentExceptionBecauseInputNumberLessThan0() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("-1,1"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void illegalArgumentExceptionBecauseInputIsNotNumber() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("1,a"))
            .isInstanceOf(RuntimeException.class);
    }
}
