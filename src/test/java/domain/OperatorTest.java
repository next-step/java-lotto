package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+:6", "-:2", "*:8", "/:2"}, delimiter = ':')
    @DisplayName("사칙 연산")
    void calculate(String operation, int result) {
        Operator operator = Operator.toOperator(operation);
        int apply = operator.apply(4, 2);
        assertThat(apply).isEqualTo(result);
    }

    @Test
    void not_operator() {
        assertThatThrownBy(() -> {
            Operator.toOperator("&");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}