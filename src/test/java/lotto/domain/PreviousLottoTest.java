package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PreviousLottoTest {

    @Test
    @DisplayName("지난 주 당첨 번호에 보너스 공이 포함되어 있으면 에러가 발생한다.")
    void valid() {
        Lotto lotto = Lotto.from(1, 2, 3, 4, 5, 6);
        Ball ball = Ball.from(6);
        assertThatThrownBy(
                () -> PreviousLotto.of(lotto, ball))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
