package calculatortest;

import calculator.domain.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationMethodTest {

    //given
    Operator sum = Operator.Sum;
    Operator subtraction = Operator.Subtraction;
    Operator multiplication = Operator.Multiplication;
    Operator division = Operator.Division;


    @Test
    @DisplayName("sum")
    public void sum() {
        Assertions.assertThat(sum.calculateApply("1", "2")).isEqualTo(3);
    }

    @Test
    @DisplayName("subtraction")
    public void subtraction() {
        Assertions.assertThat(subtraction.calculateApply("1", "2")).isEqualTo(-1);
    }

    @Test
    @DisplayName("multiplication")
    public void multiplication() {
        Assertions.assertThat(multiplication.calculateApply("1", "2")).isEqualTo(2);
    }

    @Test
    @DisplayName("division")
    public void division() {
        Assertions.assertThat(division.calculateApply("1", "2")).isEqualTo(0);
        Assertions.assertThat(division.calculateApply("3", "2")).isEqualTo(1);
        Assertions.assertThatThrownBy(() -> {
            division.calculateApply("3", "0");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
