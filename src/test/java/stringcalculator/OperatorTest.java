package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.Operator;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    void create() {
        Operator operator = new Operator("+");

        assertThat(operator).isEqualTo(new Operator("+"));
    }

    @ParameterizedTest(name = "Operator는 +,-,*,/ 이외의 문자로 생성할 경우 IllegalArgumentException 에러를 반환한다.")
    @ValueSource(strings = {"0", "&", "%", "#", "(", "="})
    void valid(String text) {
        assertThatThrownBy(() -> new Operator(text)).isInstanceOf(IllegalArgumentException.class);
    }
}
