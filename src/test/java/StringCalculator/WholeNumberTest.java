package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class WholeNumberTest {

    @Test
    @DisplayName("음수는 런타임에러 발생")
    void negativeNumberThrowsError() {
        assertThatThrownBy(()-> new WholeNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("음수는 덧셈 대상이 될 수 없습니다.");
    }
}
