package step1.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ValidatorTest {
    private final Validator validator = new Validator();

    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.assertValidInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ^ 2", "2 ! 3", "3 AND 4", "4 % 5", "5 || 6", "6 OR 7"})
    void invalidOperator(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.assertValidInput(input));
    }

    @DisplayName("연산자의 개수가 (피연산자 - 1)개 아니면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"10 + * 5", "2", "1 +"})
    void invalidOperation(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.assertValidInput(given));
    }

    @DisplayName("연산식이 숫자로 시작하지 않으면 예외를 던진다")
    @Test
    void notStartWithNumber() {
        String given = "+ 3 1";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.assertValidInput(given));
    }

}
