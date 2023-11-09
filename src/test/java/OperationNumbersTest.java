import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OperationNumbersTest {

    @Test
    void 사칙_연산을_모두_포함하는_기능을_수행할_수_있다() {
        // given
        int expectedResult = 5;
        OperationNumbers operationNumbers = new OperationNumbers(List.of(2, 3, 4, 2, 5));
        List<Operator> operators = Operator.byStringOperators(List.of("+", "*", "/", "-"));

        // when
        int result = operationNumbers.operateByOperations(operators);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
