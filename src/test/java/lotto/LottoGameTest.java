package lotto;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.WinningGrade.*;

public class LottoGameTest {
    @DisplayName("입력 받은 금액의 최대 구매금액을 구한다.")
    @Test
    void getLottoGame() {
        LottoGame lottoGame = new LottoGame(new Money(3500));
        Money lottosPrice = lottoGame.getBuyPrice();
        Assertions.assertThat(lottosPrice.toInteger()).isEqualTo(3000);
    }

    @DisplayName("로또 당첨번호 등수별 통계를 구한다.")
    @Test
    void getStatistics() {
        List<Lotto> lottos = List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 8),
                new Lotto(1, 2, 3, 4, 8, 9),
                new Lotto(1, 2, 3, 7, 8, 9),
                new Lotto(1, 2, 8, 9, 10, 11)
        );

        LottoGame lottoGame = new LottoGame(lottos);
        WinningNumbers winningNumbers = new WinningNumbers(7, 1, 2, 3, 4, 5, 6);
        WinningStatistics statistics = lottoGame.getStatistics(winningNumbers);

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
                new Lotto(1, 2, 3, 7, 8, 9),
                new Lotto(1, 2, 8, 9, 10, 11),
                new Lotto(1, 2, 8, 9, 10, 11),
                new Lotto(1, 2, 8, 9, 10, 11),
                new Lotto(1, 2, 8, 9, 10, 11),
                new Lotto(1, 2, 8, 9, 10, 11),
                new Lotto(1, 2, 8, 9, 10, 11),
                new Lotto(1, 2, 8, 9, 10, 11),
                new Lotto(1, 2, 8, 9, 10, 11),
                new Lotto(1, 2, 8, 9, 10, 11)
        );
        WinningNumbers winningNumbers = new WinningNumbers(7, 1, 2, 3, 4, 5, 6);

        LottoGame lottoGame = new LottoGame(lottos);
        Assertions.assertThat(lottoGame.getStatistics(winningNumbers).getTotalRateOfReturnForPrint()).isEqualTo("0.5");

    }

    @DisplayName("수동으로 발급할 수 있다.")
    @Test
    void issueManualQuantity() {
        LottoGame lottoGame = new LottoGame(new Money(10000), List.of(Set.of(1, 2, 3, 7, 8, 9)));
        Assertions.assertThat(lottoGame.getAllManualLottos()).hasSize(1);
        Assertions.assertThat(lottoGame.getAllManualLottos()).containsExactly(new Lotto(1, 2, 3, 7, 8, 9));
    }

    @DisplayName("수동 발급 수는 전체 발급 수보다 적어야 한다.")
    @Test
    void checkManualQuantity() {
        Assertions.assertThatThrownBy(() -> new LottoGame(new Money(1000), List.of(Set.of(1, 2, 3, 7, 8, 9), Set.of(1, 2, 3, 7, 8, 9)))).isInstanceOf(IllegalArgumentException.class);
    }
}
