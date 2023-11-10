package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.StringCalculator;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private final String COMMON_INPUT = "2 + 3 * 4 / 2";
    @Test
    @DisplayName("문자열 계산기 생성")
    void create() {
        StringCalculator stringCalculator = new StringCalculator("1");
        assertThat(stringCalculator).isInstanceOf(StringCalculator.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 IllegalException 예외 발생")
    void add(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(input));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(null));
    }

    @Test
    @DisplayName("숫자와 사칙연산 기호 이외의 문자가 포함된 경우 IllegalException 예외 발생")
    void inputCheck() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator("1,2,3"));
    }

    @Test
    @DisplayName("문자열 계산기 결과 출력")
    void result() {
        StringCalculator stringCalculator = new StringCalculator(COMMON_INPUT);
        assertThat(stringCalculator.result()).isEqualTo(10);
    }
}
