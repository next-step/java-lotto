package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈_문자열이거나_공백으로_구성된_문자열이면_예외_발생(String input) {
        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                        .withMessageMatching("빈 문자열이나 공백으로 구성된 문자열은 허용되지 않습니다");
    }
}
