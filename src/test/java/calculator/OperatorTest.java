package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @DisplayName("연산자 구하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = "-,+,*,/,&")
    void getOperator(String input) {
        if ("+".equals(input)) assertThat(Operator.findByOperator(input)).isEqualTo(Operator.PLUS);
        if ("-".equals(input)) assertThat(Operator.findByOperator(input)).isEqualTo(Operator.MINUS);
        if ("*".equals(input)) assertThat(Operator.findByOperator(input)).isEqualTo(Operator.MULTIPLY);
        if ("/".equals(input)) assertThat(Operator.findByOperator(input)).isEqualTo(Operator.DIVIDE);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.findByOperator(input);
        }).withMessageMatching("연산자를 찾을 수 없습니다.");
    }

}
