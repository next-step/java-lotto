package calculatortest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class calculationMethodTest {

    //given
    CalculationMethod sum = new Sum();
    CalculationMethod subtraction = new Subtraction();
    CalculationMethod multiplication = new Multiplication();
    CalculationMethod division = new Division();

    @Test
    @DisplayName("sum")
    public void sum() {
        Assertions.assertThat(sum.calculate("1 + 2")).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Exceptions of Sum")
    @NullAndEmptySource
    @ValueSource(strings = {"1 @ 2"})
    public void wrongSum(String string) {
        Assertions.assertThatThrownBy(() -> {
            sum.calculate(string);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("subtraction")
    public void subtraction() {
        Assertions.assertThat(subtraction.calculate("1 - 2")).isEqualTo(-1);
    }

    @ParameterizedTest
    @DisplayName("Exceptions of subtraction")
    @NullAndEmptySource
    @ValueSource(strings = {"1 @ 2"})
    public void wrongSubtraction(String string) {
        Assertions.assertThatThrownBy(() -> {
            subtraction.calculate(string);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("multiplication")
    public void multiplication() {
        Assertions.assertThat(multiplication.calculate("1 * 2")).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("Exceptions of multiplication")
    @NullAndEmptySource
    @ValueSource(strings = {"1 @ 2"})
    public void wrongMultiplication(String string) {
        Assertions.assertThatThrownBy(() -> {
            multiplication.calculate(string);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("division")
    public void division() {
        Assertions.assertThat(division.calculate("1 / 2")).isEqualTo(0);
        Assertions.assertThat(division.calculate("3 / 2")).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("Exceptions of division")
    @NullAndEmptySource
    @ValueSource(strings = {"1 @ 2", "1 / 2", " 1 / 0"})
    public void wrongDivision(String string) {
        Assertions.assertThatThrownBy(() -> {
            division.calculate(string);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}