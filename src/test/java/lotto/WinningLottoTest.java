package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("당첨된 로또의 카운트가 증가 되는지 확인한다")
    @Test
    void addCount() {
        WinningLotto winningLotto = new WinningLotto(Rank.SECOND.getWinningAmount(), 0);
        winningLotto.addCount();

        assertThat(winningLotto.getCount()).isEqualTo(1);
    }
}
