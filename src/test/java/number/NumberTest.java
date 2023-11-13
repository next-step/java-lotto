package number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    @DisplayName("문자를 양수로 변환한다. 숫자가 아니면 예외가 발생한다")
    public void no_number_or_negative_number() {
        Assertions.assertThat(Number.from("100").value()).isEqualTo(100);
        Assertions.assertThatThrownBy(() -> Number.from("*")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Number.from("-")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Number.from("xx")).isInstanceOf(IllegalArgumentException.class);
    }
}