package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = "-,+,*,/")
    void getOperator(String input) {
        if ("+".equals(input)) assertThat(Operator.findByOperator(input)).isEqualTo(Operator.PLUS);
        if ("-".equals(input)) assertThat(Operator.findByOperator(input)).isEqualTo(Operator.MINUS);
        if ("*".equals(input)) assertThat(Operator.findByOperator(input)).isEqualTo(Operator.MULTIPLY);
        if ("/".equals(input)) assertThat(Operator.findByOperator(input)).isEqualTo(Operator.DIVIDE);
    }

}
