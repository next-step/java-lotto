package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * @author : 0giri
 * @since : 2023/04/26
 */
class OperatorTest {

    @Test
    void find() {
        assertThat(Operator.find("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.find("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.find("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.find("/")).isEqualTo(Operator.DIVISION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "3"})
    void 연산자_4개_외_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy((() -> Operator.find(value)));
    }
}