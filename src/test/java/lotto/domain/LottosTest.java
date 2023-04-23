package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottosTest {

    @Test
    @DisplayName("Lotto 발급 테스트")
    void lottosTest() {
        Lottos lottos = Lottos.initLottos(Money.initMoney(5000));

        assertThat(lottos.getLottoQuantity())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("통계 테스트")
    void findStatisticsTest() {
        Lotto winningLotto = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));

        Lotto lotto_1 = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));
        Lotto lotto_2 = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "7"));
        Lotto lotto_3 = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "8", "7"));
        Lotto lotto_4 = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "8", "7"));
        Lotto lotto_5 = Lotto.initWinningLotto(List.of("1", "2", "3", "9", "8", "7"));

        Lottos lottos = new Lottos(List.of(lotto_1, lotto_2, lotto_3, lotto_4, lotto_5));

        Winners winners = lottos.findStatistics(winningLotto);

        assertAll(
                () -> assertThat(winners.getWinnersCount(6))
                        .isEqualTo(1),
                () -> assertThat(winners.getWinnersCount(5))
                        .isEqualTo(1),
                () -> assertThat(winners.getWinnersCount(4))
                        .isEqualTo(2),
                () -> assertThat(winners.getWinnersCount(3))
                        .isEqualTo(1)
        );
    }

}