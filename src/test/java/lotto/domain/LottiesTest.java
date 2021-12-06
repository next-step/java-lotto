package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottiesTest {

    @DisplayName("여러개의 로또 뭉치 생성 테스트")
    @Test
    void createLotties() {
        Lotties lotties = new Lotties(Arrays.asList(Lotto.from("1, 2, 3, 4, 5, 6")));

        assertThat(lotties).isNotNull();
    }

    @DisplayName("게임결과 테스트 - 5등 당첨 한개, 꽝 4개의")
    @Test
    void checkGameResult() {
        Lotto lotto = Lotto.from("2, 9, 13, 33, 39, 45");
        Lotto lotto2 = Lotto.from("9, 10, 11, 20, 22, 31");
        Lotto lotto3 = Lotto.from("26, 27, 36, 37, 41, 45");
        Lotto lotto4 = Lotto.from("2, 16, 28, 31, 38, 45");
        Lotto lotto5 = Lotto.from("9, 14, 16, 29, 39, 44");
        Lotties lotties = new Lotties(Arrays.asList(lotto, lotto2, lotto3, lotto4, lotto5));
        Lotto winLotto = Lotto.from("2, 4, 25, 26, 36, 37");
        LottoNumber bonusNumber = new LottoNumber("28");
        WinLotto lastWeekWinLotto = new WinLotto(winLotto, bonusNumber);

        ResultRank resultRank = lotties.gameResultRank(lastWeekWinLotto);

        assertThat(resultRank.getPrizeCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(resultRank.getPrizeCount(Rank.OUT)).isEqualTo(4);
    }

    @DisplayName("로또 목록 결합 테스트")
    @Test
    void addLottiesTest() {
        List<String> lottoPaperOne = Arrays.asList("2, 9, 13, 33 ,39, 45", "34, 40, 13, 2 ,9, 44");
        List<String> lottoPaperTwo = Arrays.asList("2, 9, 13, 33, 40, 45", "9, 10, 11, 20, 22, 31");
        Store store = new Store();
        Lotties lottiesOne = store.purchaseManualLotto(lottoPaperOne);
        Lotties lottiesTwo = store.purchaseManualLotto(lottoPaperTwo);

        lottiesOne.addLotties(lottiesTwo);

        assertThat(lottiesOne.purchaseLottiesCount()).isEqualTo(4);
    }
}
