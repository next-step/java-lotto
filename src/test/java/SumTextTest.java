import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SumTextTest {
    @DisplayName("숫자 합계")
    @Test
    public void sumTest() {
        String[] text = {"1", "2", "3"};
        SumText sumText = new SumText(text);
        assertThat(sumText.sum()).isEqualTo(6);
    }

    @DisplayName("입력값이 음수가 있을때")
    @Test
    public void checkNegativeTest() {
        String[] text = {"-1", "2", "3"};
        SumText sumText = new SumText(text);
        assertThatThrownBy(() -> sumText.sum())
                .isInstanceOf(RuntimeException.class);
    }
}
