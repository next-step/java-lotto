package calculator.util;

import calculator.operator.Addition;
import calculator.operator.Division;
import calculator.operator.Multiplication;
import calculator.operator.Subtraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    int before;
    int after;

    @BeforeEach
    void beforeEach() {
        this.before = 1;
        this.after = 1;
    }

    @Test
    @DisplayName("더하기")
    void addition() {
        assertThat(new Addition().calculate(this.before, this.after)).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기")
    void subtraction() {
        assertThat(new Subtraction().calculate(this.after, this.before)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈")
    void multiplication() {
        assertThat(new Multiplication().calculate(this.before, this.after)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    void division() {
        assertThat(new Division().calculate(this.after, this.before)).isEqualTo(1);
    }
}