package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusBallTest {

    @Test
    void bonus_ball_exception() {
        assertThatThrownBy(() -> new BonusBall(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자만 가능합니다.");
    }

    @Test
    void bonus_ball() {
        assertThat(new BonusBall(7)).isEqualTo(new BonusBall(7));
    }

}
