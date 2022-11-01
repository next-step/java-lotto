package lotto.domain;

import lotto.common.type.WinnerRank;
import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 번호와 당첨 번호가 주어졌을 때 WinnerCount 반환 확인")
    void testIfGetValidWinnerCount() {
        Lotto lotto1 = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(Set.of(11, 2, 3, 4, 5, 6));
        Lotto lotto3 = Lotto.from(Set.of(11, 22, 3, 4, 5, 6));
        Lotto lotto4 = Lotto.from(Set.of(11, 22, 33, 4, 5, 6));
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));
        Lotto winningLottoNumbers = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));

        RewardStatistics result = lottos.match(new WinningLotto(winningLottoNumbers, new LottoNumber(7)));

        RewardStatistics expected = new RewardStatistics();
        expected.plusCount(WinnerRank.FIRST);
        expected.plusCount(WinnerRank.THIRD);
        expected.plusCount(WinnerRank.FORTH);
        expected.plusCount(WinnerRank.FIFTH);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호와 보너스 당첨 번호가 주어졌을 때 WinnerCount 반환 확인")
    void testIfGetValidWinnerCountWithBonus() {
        Lotto lotto1 = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(Set.of(11, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));
        Lotto winningLottoNumbers = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));

        RewardStatistics result = lottos.match(new WinningLotto(winningLottoNumbers, new LottoNumber(11)));

        RewardStatistics expected = new RewardStatistics();
        expected.plusCount(WinnerRank.FIRST);
        expected.plusCount(WinnerRank.SECOND);
        assertThat(result).isEqualTo(expected);
    }
}
