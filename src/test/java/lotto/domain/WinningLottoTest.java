package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("정답로또/로또와비교/등수반환")
    void getPrize() {
        // given
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when then
        assertThat(winningLotto.getPrize(lotto)).isEqualTo(LottoPrize.FirstPrizeMoney);
    }
}
