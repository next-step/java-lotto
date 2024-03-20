package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @ParameterizedTest(name = "입력값에 대한 유효성 검증 실패 : null값이 들어옴")
    @NullSource
    void validate__ShouldThrowException__WithNull(String input) {
        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validator.validate(input);
        });
    }

    @ParameterizedTest(name = "입력값에 대한 유효성 검증 실패 : 빈값, 공백값이 들어옴")
    @ValueSource(strings={"", " "})
    void validate__ShouldThrowException__WithBlank(String input) {
        // when, then
        assertThatThrownBy(() ->  validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Blank input is not allowed");
    }

    @ParameterizedTest(name = "입력값에 대한 유효선 검증 실패 : 숫자가 아닌 알파벳, 특수기호가 들어옴")
    @ValueSource(strings={"a + b - c", "10 - 9 ! 3"})
    void validate__ShouldThrowException__WithAlphabet(String input) {
        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validator.validate(input);
        });
    }

    @ParameterizedTest(name = "입력값에 대한 유효선 검증 실패 : 숫자가 아닌 알파벳, 순서 오류")
    @ValueSource(strings={"10 +", "- 10 +", "* 10"})
    void validate__ShouldThrowException__WrongSequence(String input) {
        // when, then
        assertThatThrownBy(() ->  validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Wrong Sequence");
    }
}
