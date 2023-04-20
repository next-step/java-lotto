package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    void Operator_생성() {
        String operator = new Operator("*").value();
        assertThat(operator).isEqualTo("*");
    }
}
