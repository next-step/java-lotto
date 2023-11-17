package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @ParameterizedTest
    @DisplayName("null일 경우 IllegalArgumentException 발생한다.")
    @NullAndEmptySource
    void Null_을_입력할_경우_IllegalArgumentException_발생한다(String value) {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.checkNullOrEmpty(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
