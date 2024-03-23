package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    void winning_number_exception() {
        assertThatThrownBy(() -> new WinningNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 1부터 45 사이의 숫자만 가능합니다.");
    }

    @Test
    void winning_number() {
        assertThat(new WinningNumber(1)).isEqualTo(new WinningNumber(1));
    }

}
