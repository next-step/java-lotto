package calculator;

import calculator.domain.Content;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    public void add() {
        assertThat(Calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    public void subtract() {
        assertThat(Calculator.subtract(1, 3)).isEqualTo(-2);
    }

    @Test
    public void multiply() {
        assertThat(Calculator.multiply(3, 6)).isEqualTo(18);
    }

    @Test
    public void divide() {
        assertThat(Calculator.divide(10, 2)).isEqualTo(5);
    }

    @Test
    public void calculate() {
        List<Content> list = new ArrayList<>();
        list.add(new Content(2));
        list.add(new Content("+"));
        list.add(new Content(3));
        list.add(new Content("*"));
        list.add(new Content(4));
        list.add(new Content("/"));
        list.add(new Content(2));

        Calculator calculator = new Calculator(list);
        assertThat(calculator.calculate()).isEqualTo(10);
    }
}
