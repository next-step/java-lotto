package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void valid() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(()-> calculator.compute(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> calculator.compute("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> calculator.compute("     ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> calculator.compute("2+3*4/2")).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void compute(){
        Calculator calculator = new Calculator();
        assertThat(calculator.compute("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}