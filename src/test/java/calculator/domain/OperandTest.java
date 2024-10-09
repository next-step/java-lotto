package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperandTest {
    @ParameterizedTest
    @ValueSource(strings = {"1","3","5","7","9"})
    @DisplayName("valueOf로 생성하면 input으로 넣은 value를 가지고 있습니다")
    void valueOfTest(String value) {
        Operand operand = Operand.valueOf(value);
        assertThat(operand.value()).isEqualTo(Integer.parseInt(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1d","3c","5b","a","x"})
    @DisplayName("숫자가 아닌 값으로 valueOf를 시도하면 IllegalArgumentException을 띄웁니다")
    void valueOfExceptionTest(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operand.valueOf(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","3","5","7","9"})
    @DisplayName("같은 value로 만들어진 operand는 equals true를 리턴합니다 ")
    void equalsTest(String value) {
        Operand operand1 = Operand.valueOf(value);
        Operand operand2 = Operand.valueOf(value);
        assertThat(operand1).isEqualTo(operand2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","3","5","7","9"})
    @DisplayName("같은 value로 만들어진 operand는 hashCode가 같습니다.")
    void hashCodeTest(String value) {
        Operand operand1 = Operand.valueOf(value);
        Operand operand2 = Operand.valueOf(value);
        assertThat(operand1.hashCode()).isEqualTo(operand2.hashCode());
    }
}
