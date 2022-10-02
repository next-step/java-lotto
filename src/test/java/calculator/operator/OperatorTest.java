package calculator.operator;

import calculator.exception.ParsingOperatorFailureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class OperatorTest {

    @ParameterizedTest(name = "유효하지 않은 연산자 파싱 - input: {0}")
    @ValueSource(strings = {"`", "~", "!", "@", "#", "$", "%", "^", "&"})
    void invalidOperator(String operatorStr) {
        // given & when & then
        assertThatThrownBy(() -> Operator.valueOf(operatorStr)).isInstanceOf(ParsingOperatorFailureException.class)
                                                               .hasMessageContaining("지원하지 않는 연산자입니다.");
    }

    @DisplayName("유효한 연산자 파싱 (+, -, *, /)")
    @Test
    void valueOfOperator() {
        // given & when & then
        assertAll(
                () -> assertThat(Operator.valueOf("+")).isInstanceOf(AddOperator.class),
                () -> assertThat(Operator.valueOf("-")).isInstanceOf(SubOperator.class),
                () -> assertThat(Operator.valueOf("*")).isInstanceOf(MulOperator.class),
                () -> assertThat(Operator.valueOf("/")).isInstanceOf(DivOperator.class)
        );
    }
}
