

import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class stringCalculatorTest {

    @Test
    @DisplayName("문자열 계산")
    public void calculator() {

        Calculator calculator = new Calculator();

        assertThat(calculator.operation(1, 2, '-')).isEqualTo(-1);
        assertThat(calculator.operation(1, 2, '+')).isEqualTo(3);
        assertThat(calculator.operation(4, 2, '/')).isEqualTo(2);
        assertThat(calculator.operation(2, 3, '*')).isEqualTo(6);

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.operation(1, 2, 'a'));
    }
}