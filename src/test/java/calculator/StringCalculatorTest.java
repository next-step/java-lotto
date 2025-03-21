package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class StringCalculatorTest {

    @Test
    @DisplayName("주어진 elements대로 계산해야 한다")
    void calculate() {
        List<Element> elements = List.of(
                new Element(Operator.START, 2),
                new Element(Operator.PLUS, 3),
                new Element(Operator.MULTIPLY, 4),
                new Element(Operator.DIVIDE, 2)
        );

        int result = StringCalculator.calculate(elements);

        Assertions.assertThat(result).isEqualTo(10);
    }
}
