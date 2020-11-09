package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @DisplayName("당첨번호를 제공받는다.")
    @Test
    void constructWithNumberSelection() {
        Assertions.assertThatCode(() -> {
            new WinningNumber(new TestingNumberSelection(1, 2, 3, 4, 5, 6));
        }).doesNotThrowAnyException();
    }
}
