package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {

    @DisplayName("덧셈 기능 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "3,5,8"})
    void sumTest(String x, String y, int total) {
        Number number = Number.of(x);
        int sum = number.sum(Integer.parseInt(y));

        assertThat(sum).isEqualTo(total);
    }

    @DisplayName("음수 검증 확인")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-12"})
    void minusValidTest(String source) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Number.of(source))
                .withMessage("음수는 허용되지 않습니다.");
    }

    @DisplayName("잘못된 문자열 검증 확인")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "134d"})
    void incorrectStringValidTest(String source) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Number.of(source))
                .withMessage("숫자로 변환이 불가능한 문자열입니다.");
    }
}
