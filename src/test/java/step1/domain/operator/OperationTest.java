package step1.domain.operator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step1.domain.operator.Operation.from;

class OperationTest {

    @ParameterizedTest
    @CsvSource(value = {"+", "-", "*", "/"})
    void 사칙_연산_연산자_테스트(String input) {
        assertThat(from(input)).isInstanceOf(Operation.class);
        assertThat(from(input).getOperator()).isInstanceOf(Operator.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"^", "&"})
    void 사칙_연산_연산자_테스트_오류(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> from(input));
    }
}