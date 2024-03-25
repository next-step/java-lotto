package operations;

import domain.operations.CalculateStrategy;
import domain.operations.OperationStrategies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationStrategiesTest {

    @DisplayName("문자열을 순서대로 사칙연상을 할 수 있다,")
    @ParameterizedTest
    @CsvSource(value = {"+,Add", "-,Minus", "/,Division", "*,Multiplication"}, delimiterString = ",")
    void calculate(String input, String expectedResult) {
        CalculateStrategy operation = OperationStrategies.getOperation(input);
        assertThat(operation.getClass().getSimpleName()).isEqualTo(expectedResult);
    }
}
