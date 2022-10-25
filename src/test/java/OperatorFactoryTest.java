import calculator.operator.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorFactoryTest {

    @Test
    void 사칙연산_중_하나() {
        assertThat(OperatorFactory.getOperator("+")).isEqualTo(AddOperator.getOperator());
        assertThat(OperatorFactory.getOperator("-")).isEqualTo(SubtractOperator.getOperator());
        assertThat(OperatorFactory.getOperator("*")).isEqualTo(MultiplyOperator.getOperator());
        assertThat(OperatorFactory.getOperator("/")).isEqualTo(DivideOperator.getOperator());
    }


    @ParameterizedTest
    @ValueSource(strings = {"%", "#", "@"})
    void 사칙연산이_아닌_경우_IllegalArgumentException(String str) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> OperatorFactory.getOperator(str));
    }
}
