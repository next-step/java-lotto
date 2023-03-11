package lotto;

import lotto.domain.WinningStatistics;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LotteryNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.domain.WinningGrade.*;

public class LottoGameTest {
    @DisplayName("입력 받은 금액의 최대 구매금액을 구한다.")
    @Test
    void getLottoGame() {
        LottoGame lottoGame = new LottoGame(3500);
        int lottosPrice = lottoGame.getBuyPrice();
        Assertions.assertThat(lottosPrice).isEqualTo(3000);
    }

    @DisplayName("로또 당첨번호 등수별 통계를 구한다.")
    @Test
    void getStatistics() {
        List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 7)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 8)),
                new Lotto(Set.of(1, 2, 3, 4, 8, 9)),
                new Lotto(Set.of(1, 2, 3, 7, 8, 9)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11))
        );

        LottoGame lottoGame = new LottoGame(lottos);
        LotteryNumbers lotteryNumbers = new LotteryNumbers(Set.of(1, 2, 3, 4, 5, 6), 7);
        WinningStatistics statistics = lottoGame.getStatistics(lotteryNumbers);

        Assertions.assertThat(statistics.getWinningNumbers(FIRST_PRIZE)).isEqualTo(1);
        Assertions.assertThat(statistics.getWinningNumbers(SECOND_PRIZE)).isEqualTo(1);
        Assertions.assertThat(statistics.getWinningNumbers(THIRD_PRIZE)).isEqualTo(1);
        Assertions.assertThat(statistics.getWinningNumbers(FORTH_PRIZE)).isEqualTo(1);
        Assertions.assertThat(statistics.getWinningNumbers(FIFTY_PRIZE)).isEqualTo(1);
        Assertions.assertThat(statistics.getWinningNumbers(ETC)).isEqualTo(1);
    }

    @DisplayName("총 수익률을 구한다.")
    @Test
    void getTotalRateOfReturn() {
        List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 7, 8, 9)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11)),
                new Lotto(Set.of(1, 2, 8, 9, 10, 11))
        );
        LotteryNumbers lotteryNumbers = new LotteryNumbers(Set.of(1, 2, 3, 4, 5, 6), 7);

        LottoGame lottoGame = new LottoGame(lottos);
        Assertions.assertThat(lottoGame.getTotalRateOfReturn(lotteryNumbers)).isEqualTo(0.5);

    }

}
