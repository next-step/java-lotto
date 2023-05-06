package domain;

import static domain.Operator.IS_NOT_SYMBOL_ERROR_MESSAGE;
import static domain.Operator.validateOperatorSymbol;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @ParameterizedTest(name = "사칙연산 부호가 아닐경우 exception 발생, {0} 의 경우")
    @ValueSource(strings = {"_", "!", "@", "#"})
    void operatorTest(String input) {
        List<String> stringList = Collections.singletonList(input);
        Assertions.assertThatThrownBy(() -> validateOperatorSymbol(stringList))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_SYMBOL_ERROR_MESSAGE);
    }
}
