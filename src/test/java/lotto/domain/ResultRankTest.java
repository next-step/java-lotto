package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultRankTest {

    private Lotties lotties;
    private WinLotto lastWeekWinLotto;


    @BeforeEach
    void setUp() {
        Lotto lotto = Lotto.from("4, 8, 18, 21, 32, 39");
        Lotto lotto2 = Lotto.from("5, 6, 7, 21, 32, 39");
        Lotto lotto3 = Lotto.from("5, 6, 8, 22, 35, 36");
        Lotto lotto4 = Lotto.from("5, 6, 7, 8, 9, 15");
        Lotto lotto5 = Lotto.from("1, 2, 3, 41, 22, 40");
        this.lotties = new Lotties(Arrays.asList(lotto, lotto2, lotto3, lotto4, lotto5));
        Lotto winLotto = Lotto.from("4, 8, 18, 22, 34, 40");
        LottoNumber bonusNumber = new LottoNumber("31");
        this.lastWeekWinLotto = new WinLotto(winLotto, bonusNumber);
    }

    @DisplayName("구매한 로또의 수익률 계산")
    @Test
    void lottoGameRateCheck() {
        ResultRank resultRank = lotties.gameResultRank(lastWeekWinLotto);

        assertThat(resultRank.getRate(lotties.getLottiesPrice())).isEqualTo(1.0);
    }

    @DisplayName("구매한 로또의 랭크 및 당첨 갯수를 체크")
    @Test
    void lottoGameRankCheck() {
        ResultRank resultRank = lotties.gameResultRank(lastWeekWinLotto);

        assertThat(resultRank.getPrizeCount(Rank.FIFTH)).isEqualTo(1);
    }
}
