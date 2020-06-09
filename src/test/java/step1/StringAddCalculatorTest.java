package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기 클래스 테스트")
public class StringAddCalculatorTest {

    @Test
    @DisplayName("숫자 문자 배열 합을 구한다")
    void 배열_다_더하기() {
        String[] numbers = {"1", "2", "3", "4"};
        assertThat(StringAddCalculator.sum(numbers)).isEqualTo(10);
    }

    @Test
    @DisplayName("음수와 숫자 이외의 값은 RuntimeException")
    void 숫자아니면_RUNTIMEEXCEPTION() {
        String[] numbers = {"zz", "dd", "-3", "4"};
        assertThatThrownBy(() -> {
            StringAddCalculator.sum(numbers);
        }).isInstanceOf(RuntimeException.class);


    }
}
