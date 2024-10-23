package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class LotteryTest {
    @Test
    void 당첨번호와_일치하는_번호_개수_구하기() {
        // given
        WinningLottery winningLottery = new WinningLottery(
                new Lottery(Set.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(7)
        );
        Lottery lottery = new Lottery(Set.of(1, 2, 10, 11, 12, 13));

        // when
        int equalNumberCount = lottery.countWinningNumbers(winningLottery);

        // then
        Assertions.assertThat(equalNumberCount).isEqualTo(2);
    }

    @Test
    void 로또번호가_6개가_아니면_예외_발생() {
        // given
        Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5);

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lottery(lottoNumbers))
                .withMessageMatching("로또번호는 \\d+개 이어야 합니다");
    }
}
