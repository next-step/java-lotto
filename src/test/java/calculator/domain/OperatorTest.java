package calculator.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @ParameterizedTest(name = "연산자생성/ `{0}` / 생성완료")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void createOperator(String operator) {
        // when then
        assertThat(new Operator(operator)).isInstanceOf(Operator.class);
    }

    @Test
    @DisplayName("연산자생성/연산기호가아닌것/IllegalArgumentException")
    void createOperatorFail() {
        // when then
        assertThatIllegalArgumentException().isThrownBy(() -> new Operator("0"));
    }


}