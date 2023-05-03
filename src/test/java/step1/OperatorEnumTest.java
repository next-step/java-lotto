package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorEnumTest {

    @ParameterizedTest
    @CsvSource(value = {"%"})
    void 사친연산_기호가_아닌경우(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> OperatorEnum.getOperator(input))
            .withMessage("사칙연산 기호가 아닙니다");
    }
}
