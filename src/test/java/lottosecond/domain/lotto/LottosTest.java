package lottosecond.domain.lotto;

import lottosecond.domain.*;
import lottosecond.domain.lottomaker.LottoMaker;
import lottosecond.domain.lottomaker.TestLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private LottoMaker lottoMaker;
    private TotalLottoCount lottoCount;

    @BeforeEach
    void setUp() {
        lottoCount = new TotalLottoCount(new Money(1000), 0);
        lottoMaker = new LottoMaker(new TestLottoNumberGenerator());
    }

    @DisplayName("추가 로또 번호도 확인해야 합니다.")
    @Test
    void bonusNumber() {
        // given
        Lottos lottos = lottoMaker.makeLottos(LottoCount.from(1, 1));
        WinningCondition winningCondition = new WinningCondition(new Lotto(List.of(1, 2, 3, 4, 5, 9)), LottoNumber.of(6));
        // when
        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningCondition);
        // then
        assertThat(winnerBoard).isEqualTo(new WinnerBoard(List.of(Winner.SECOND)));

    }

    @Test
    @DisplayName("일치하는 당첨 로또들을 일치 수에 맞도록 winnerBoard 에 추가합니다.")
    void checkLotto() {
        // given
        Lottos lottos = lottoMaker.makeLottos(LottoCount.from(1, 1));
        WinningCondition winningCondition = new WinningCondition(new Lotto(List.of(1, 2, 3, 7, 8, 9)), LottoNumber.of(4));
        // when
        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningCondition);
        // then
        assertThat(winnerBoard).isEqualTo(new WinnerBoard(List.of(Winner.FIFTH)));
    }

    @Test
    @DisplayName("우승 로또가 없다면 winnerBoard 의 우승 로또 수는 모두 0이 됩니다.")
    void zeroWinningLotto() {
        // given
        Lottos lottos = lottoMaker.makeLottos(LottoCount.from(1, 1));
        WinningCondition winningCondition = new WinningCondition(new Lotto(List.of(11, 12, 13, 14, 15, 16)), LottoNumber.of(4));
        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningCondition);
        // then
        assertThat(winnerBoard).isEqualTo(new WinnerBoard(List.of()));
    }

    @DisplayName("Winner 리스트를 상금 오름차 순으로 정렬해서 WinnerBoard를 반환합니다.")
    @Test
    void order() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));

        Lotto targetLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        WinningCondition winningCondition = new WinningCondition(targetLotto, LottoNumber.of(7));
        // when
        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningCondition);
        // then
        assertThat(winnerBoard).isEqualTo(
                new WinnerBoard(List.of(Winner.FIFTH, Winner.FOURTH, Winner.SECOND, Winner.FIRST))
        );
    }
}