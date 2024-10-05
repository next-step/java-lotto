package stringcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.operator.Division;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DivisionTest {
    private Division division;

    @BeforeEach
    void setUp() {
        division = new Division();
    }

    @DisplayName("4과 2를 나눌 수 있다.")
    @Test
    void calculate() {

        int result = division.calculate(4, 2);

        assertThat(result).isEqualTo(2);
    }
    @DisplayName("두 수를 나눌 때 정수로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void calculateThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> division.calculate(4, 3));
    }
    @DisplayName("0으로 나누려 하면 예외가 발생한다.")
    @Test
    void calculateThrowExceptionWithDivideZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> division.calculate(4, 0));

    }

    @DisplayName("연산자가 /이면 true를 반환한다.")
    @Test
    void supports() {
        assertThat(division.supports("/")).isTrue();
    }

    @DisplayName("연산자가 /가 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*"})
    void supportsReturnFalse(String operator) {
        assertThat(division.supports(operator)).isFalse();
    }


}