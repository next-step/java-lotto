package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @DisplayName("사칙 연산자인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"^", "%", "!"})
    void 사칙연산_기호가_아닌_경우(String symbol) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of(symbol))
                .withMessageMatching("해당 연산자는 사칙연사자가 아닙니다.");
    }

}
