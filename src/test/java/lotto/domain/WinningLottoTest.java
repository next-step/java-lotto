package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinningLottoTest {

    @Test
    @DisplayName("정답로또/로또와비교/몇개가맞는지 반환")
    void matchCount() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when then
        Assertions.assertThat(winningLotto.matchCount(lotto)).isEqualTo(6);
    }
}
