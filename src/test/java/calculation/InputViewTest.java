package calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @Test
    @DisplayName("입력값이 null이거나 빈 공백인 경우 IllegalArgumentException")
    void 입력값_공백() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputView.isNullOrBlank(null);
                }).withMessageMatching("null이거나 빈 공백 문자열입니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.isNullOrBlank("");
        });
    }

}
