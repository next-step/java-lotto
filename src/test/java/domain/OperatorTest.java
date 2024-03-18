package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void if_not_operator(){
        boolean condition = Operator.isOperator("&");
        assertThat(condition).isEqualTo(false);
    }

    @Test
    void if_operator(){
        boolean condition = Operator.isOperator("*");
        assertThat(condition).isEqualTo(true);
    }
}