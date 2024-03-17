package step1.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperationValidatorTest {
    private final OperationValidator validator = new OperationValidator();

    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.assertOperation(input));
    }

    @DisplayName("연산자 = 피연산자 - 1")
    @ParameterizedTest
    @ValueSource(strings = {"10 + * 5", "2", "1 +"})
    void 연산자와_피연산자의_개수가_맞지않으면_예외를_던진다(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.assertOperation(given));
    }

}
