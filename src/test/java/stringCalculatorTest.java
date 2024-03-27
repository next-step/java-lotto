

import controller.CalculatorController;
import domain.Calculator;
import domain.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import view.Result;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class stringCalculatorTest {

    @Test
    @ParameterizedTest
    @CsvSource({
            "+,2,2,4",
            "-,2,2,0",
            "/,4,2,2",
            "*,2,3,6"
    })
    @DisplayName("문자열 계산")
    public void calculator(String operator, int num1, int num2, int expectedResult) {
        Operation operation = Operation.of(operator);
        int actualResult = operation.apply(num1, num2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("입력값 예외")
    public void exception() {
        Result result = new Result();

        assertThatIllegalArgumentException().isThrownBy(() -> result.input()).withMessage("잘못된 입력값 입니다");
    }
}