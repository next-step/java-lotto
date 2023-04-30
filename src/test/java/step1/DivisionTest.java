package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DivisionTest {

    @Test
    @DisplayName("Division 연산확인")
    void calculate() {
        // given
        Division division = new Division();
        int num1 = 10;
        int num2 = 5;

        //when
        int result = division.calculate(num1, num2);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("division by zero 확인")
    void calculateWithZeroDivisor() {
        // given
        Division division = new Division();
        int num1 = 10;
        int num2 = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> division.calculate(num1, num2))
                .withMessageContaining("Cannot divide by zero.");
    }

}
