package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {

    @Test
    void calculateTest(){
        String[] inputValue = {"1", "2", "3", "4"};

        Calculator calculator = new Calculator();

        assertThat(calculator.calculate(inputValue)).isEqualTo(10);
    }

    @Test
    void validateTest(){
        String[] inputValue = {"1", "-2", "3", "4", "5"};

        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.calculate(inputValue))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void textCalculateTest(){
        String[] inputValue = {"a", "B", "2", "d"};

        Calculator calculator = new Calculator();

        assertThat(calculator.calculate(inputValue)).isEqualTo(5);
    }
}
