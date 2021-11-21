package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @Test
    void create() {
        assertThat(new Operand("0")).isEqualTo(new Operand("0"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "", "a"})
    void createFail(String wrongString) {
        assertThatThrownBy(() -> {
            new Operand(wrongString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("피연산자는 0 이상의 양수여야합니다.");
    }

}
