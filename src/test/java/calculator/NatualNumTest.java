package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NatualNumTest {

    @Test
    @DisplayName("음수가 입력되면 IllegalArgumentException 이 발생한다.")
    public void negativeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new NatualNum(-1));
    }

}