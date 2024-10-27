package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class WinningLotteryTest {
    @Test
    void 당첨로또에_보너스번호_포함_불가() {
        // given
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottery(winningNumbers, bonusNumber))
                .withMessage("당첨로또에는 보너스번호가 포함될 수 없습니다");
    }

    @Test
    void 로또순위_추첨() {
        // given
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLottery winningLottery = new WinningLottery(winningNumbers, bonusNumber);
        Lottery lottery = new Lottery(Set.of(1, 2, 3, 4, 5, 7));

        // when
        LottoRank lottoRank = winningLottery.createLottoRank(lottery);

        // then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }
}
