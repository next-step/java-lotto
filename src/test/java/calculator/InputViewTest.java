package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null 이면 IllegalArgumentException 발생")
    public void enter_null_throwsIllegalArgumentException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView().checkNotBlank(input));
    }


}