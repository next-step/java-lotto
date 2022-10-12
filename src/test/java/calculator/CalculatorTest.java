package calculator;

import calculator.domain.Calculator;
import calculator.domain.Operator;
import calculator.domain.Plus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("단일 숫자만 입력되면 그 값을 그대로 반환한다.")
    void singleNumber() {
        int number = 4;

        int result = new Calculator(number, new ArrayList<>()).calculate();

        assertThat(result).isEqualTo(number);
    }

    @Test
    @DisplayName("단순 더하기 검증")
    void plus() {
        int number = 4;
        List<Operator> operator = new ArrayList<>();
        operator.add(new Plus(6));

        int result = new Calculator(number, operator).calculate();

        assertThat(result).isEqualTo(10);
    }
}
