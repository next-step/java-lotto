package number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    @DisplayName("문자를 양수로 변환한다. 숫자가 아니거나 음수인 경우 예외가 발생한다")
    public void no_number_or_negative_number() {
        Assertions.assertThatThrownBy(() -> Number.from("x")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Number.from("-1")).isInstanceOf(IllegalArgumentException.class);
    }
}