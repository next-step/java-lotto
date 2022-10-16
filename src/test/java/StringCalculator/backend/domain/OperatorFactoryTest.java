package StringCalculator.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorFactoryTest {

    @ParameterizedTest(name = "{index} : contains {0}")
    @CsvSource({"+", "-", "*", "/"})
    void contains_symbol(String symbol) {
        assertThat(OperatorFactory.getOperator(symbol)).isInstanceOf(Operator.class);
    }

    @ParameterizedTest(name = "{index} : not contains {0}")
    @CsvSource({"%", "="})
    void not_contains_symbol(String symbol) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> OperatorFactory.getOperator(symbol));
    }
}
