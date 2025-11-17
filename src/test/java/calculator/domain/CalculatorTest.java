package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 덧셈(){
        int result = Calculator.plus(new TargetNumber("4", "2"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 뺄셈(){
        int result = Calculator.minus(new TargetNumber("4", "2"));
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 곱셈(){
        int result = Calculator.multiplication(new TargetNumber("4", "2"));
        assertThat(result).isEqualTo(8);
    }

    @Test
    void 나눗셈(){
        int result = Calculator.division(new TargetNumber("4", "2"));
        assertThat(result).isEqualTo(2);
    }


}
