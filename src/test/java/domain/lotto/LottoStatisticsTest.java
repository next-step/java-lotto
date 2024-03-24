package domain.lotto;

import controller.lotto.LottoStatistics;
import domain.common.Money;
import domain.lotto.LottoPrize;
import domain.lotto.UserLotto;
import domain.lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


class LottoStatisticsTest {
    UserLotto userLotto;
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        userLotto = UserLotto.from(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(14, 16, 17, 24, 25, 26)));
        winningLotto = WinningLotto.from(List.of(1, 2, 3, 7, 8, 10), 19);
    }

    @DisplayName("유저의 로또 통계를 생성할 수 있다.")
    @Test
    void from() {
        LottoStatistics lottoStatistics = LottoStatistics.from(userLotto, winningLotto);
        Map<LottoPrize, Integer> prize = lottoStatistics.prize();
        Integer matchCount = prize.get(LottoPrize.FIFTH);

        Assertions.assertThat(matchCount).isEqualTo(1);
    }

    @DisplayName("수익률을 구할 수 있다.")
    @Test
    void prizeStatistics() {
        LottoStatistics lottoStatistics = LottoStatistics.from(userLotto, winningLotto);
        double result = lottoStatistics.prizeStatistics(new Money(14000));
        Assertions.assertThat(result).isEqualTo(0.35);
    }
}
