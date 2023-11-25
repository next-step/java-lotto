package lotto;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottosTest {

    @Test
    void 당첨_금액을_알려준다() {
        Map<Rank, Integer> rankMap = Map.of(Rank.FIRST, 1);
        WinningLottos winningLottos = new WinningLottos(rankMap);
        assertThat(winningLottos.rewardWinningLotto(6, false)).isEqualTo(2000000000);
    }

    @Test
    void 당첨_금액의_총액을_알려준다() {
        Map<Rank, Integer> rankMap = Map.of(Rank.FIRST, 1, Rank.FOURTH, 1);
        WinningLottos winningLottos = new WinningLottos(rankMap);
        assertThat(winningLottos.totalRewardWinningLottos()).isEqualTo(2000050000);
    }

    @Test
    void 당첨번호와_일치하는_갯수별로_로또갯수를_저장한다() {
        Map<Rank, Integer> rankMap = Map.of(Rank.FIRST, 1, Rank.FOURTH, 1);
        WinningLottos winningLottos = new WinningLottos(rankMap);
        assertAll(() -> {
            assertThat(winningLottos.countLottoByWinningNumber(6, false)).isEqualTo(1);
            assertThat(winningLottos.countLottoByWinningNumber(4, false)).isEqualTo(1);
        });
    }

    @Test
    void 당첨순위로_로또갯수를_저장한다() {
        Map<Rank, Integer> rankMap = Map.of(Rank.FIRST, 1, Rank.FOURTH, 1);
        WinningLottos winningLottos = new WinningLottos(rankMap);
        assertAll(() -> {
            assertThat(winningLottos.countLottoByWinningNumber(Rank.FIRST)).isEqualTo(1);
            assertThat(winningLottos.countLottoByWinningNumber(Rank.FOURTH)).isEqualTo(1);
        });
    }
}