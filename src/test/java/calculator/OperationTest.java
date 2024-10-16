package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    @Test
    void apply_숫자_2개의_덧셈_결과를_반환한다() {
        assertThat(Operation.PLUS.apply(1, 2)).isEqualTo(3);
    }

    @Test
    void apply_숫자_2개의_뺄셈_결과를_반환한다() {
        assertThat(Operation.MINUS.apply(6, 2)).isEqualTo(4);
    }

    @Test
    void apply_숫자_2개의_곱셈_결과를_반환한다() {
        assertThat(Operation.MULTIPLY.apply(8, 2)).isEqualTo(16);
    }

    @Test
    void apply_숫자_2개의_나눗셈_결과를_반환한다() {
        assertThat(Operation.DIVIDE.apply(6, 2)).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
    void getOperation_연산자에_해당하는_enum을_반환한다(String symbol, String operation) {
        assertThat(Operation.getOperation(symbol)).isEqualTo(Operation.valueOf(operation));
    }
}
