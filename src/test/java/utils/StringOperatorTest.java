package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringOperatorTest {

    @Test
    public void 혀용되는_연산기호가_아닌경우_error_throw() {
        assertThatThrownBy(() -> StringOperator.from("a"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("지원하지 않는 연산자입니다:");
    }

    @Test
    public void 나머지연산인경우_나눠떨어지지않으면_error_throw() {
        assertThatThrownBy(() -> StringOperator.from("/").calculate("1", "3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("나머지가 존재합니다. 연산이 불가능합니다.");
    }

    @ParameterizedTest
    @CsvSource({
        "'+', '3', '5', '8'",
        "'-', '10', '4', '6'",
        "'*', '2', '6', '12'",
        "'/', '12', '3', '4'"
    })
    public void 정상케이스_테스트(String symbol, String leftOperand, String rightOperand, String expected) {
        String result = StringOperator.from(symbol).calculate(leftOperand, rightOperand);
        assertThat(result).isEqualTo(expected);
    }
}
