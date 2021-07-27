import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"})
    @DisplayName("문자열을 쉼표, 혹은 콜론으로 구분한다.")
    void splitStringAndReturnNumberList(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @NullAndEmptySource
    @DisplayName("빈 문자열 혹은 NULL 입력시 0 을 반환한다.")
    void splitEmptyStringAndReturnNumberList(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"-1,2,3", "x:2:3"})
    @DisplayName("숫자 외에, 음수를 전달하면 에러가 발생한다.")
    void splitInvalidParameter(String input) {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정 할 수 있다.")
    void splitCustomStringAndReturnNumberList() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

}
