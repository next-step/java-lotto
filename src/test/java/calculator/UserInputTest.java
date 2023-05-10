package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserInputTest {
    @ParameterizedTest
    @NullAndEmptySource
    void nullInputValidation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserInput(input));
    }

    @Test
    void NonArithmeticOperatorInputValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserInput("1 + 2 $ 5"));
        assertThatIllegalArgumentException().isThrownBy(() -> new UserInput("1 * 3 ^ 9"));
        assertThat(new UserInput("1 + 2 / 3")).isInstanceOf(UserInput.class);
        assertThat(new UserInput("1 * 2 / 3 - 4")).isInstanceOf(UserInput.class);
    }
}
