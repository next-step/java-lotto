package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInputTest {

    @DisplayName("음수값 테스트")
    @Test
    void validateInputNegativeTest() {
        String input = "-3,4";
        assertThatThrownBy(() -> {
            new ValidateInput(input);
        }).isInstanceOf(RuntimeException.class);

    }

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        assertTrue(new ValidateInput(input).validateInputNull(input));
    }
}
