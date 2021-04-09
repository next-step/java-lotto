package lotto;

import lotto.domain.Rank;
import lotto.domain.WinningCount;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_5등() {
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(Arrays.asList(33,44,45,4,5,6));
        WinningCount winningCount = winningLotto.winningLottoCount(lotto, 7);
        Rank result = Rank.of(winningCount.getWinningCount(), winningCount.isBonus());
        assertThat(result).isEqualTo(Rank.FIFTH);
    }
    @Test
    void 로또_1등() {
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(Arrays.asList(4,3,5,2,6,1));
        WinningCount winningCount = winningLotto.winningLottoCount(lotto, 7);
        Rank result = Rank.of(winningCount.getWinningCount(), winningCount.isBonus());
        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    void 로또_2등() {
        Lotto winningLotto = new Lotto(Arrays.asList(2,11,17,21,29,43));
        Lotto lotto = new Lotto(Arrays.asList(2, 11, 17, 21, 29, 44));
        WinningCount winningCount = winningLotto.winningLottoCount(lotto, 10);
        Rank result = Rank.of(winningCount.getWinningCount(), winningCount.isBonus());
        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    void 로또_당첨_없음() {
        Lotto winningLotto = new Lotto(Arrays.asList(1,21,31,41,51,6));
        Lotto lotto = new Lotto(Arrays.asList(4,3,5,2,6,10));
        WinningCount winningCount = winningLotto.winningLottoCount(lotto, 44);
        Rank result = Rank.of(winningCount.getWinningCount(), winningCount.isBonus());
        assertThat(result).isEqualTo(Rank.MISS);
    }
}
