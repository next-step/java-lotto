package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        List<WinningInformation> winningInformations = List.of(
                WinningInformation.of(6),
                WinningInformation.of(6),
                WinningInformation.of(3),
                WinningInformation.of(0)
        );
        winningStatistics = new WinningStatistics(winningInformations);
    }

    @DisplayName("로또리스트와 지난주 당첨 로또로 로또통계를 생성할 수 있다.")
    @Test
    void of() {
        List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                new Lotto(Set.of(4, 5, 6, 7, 8, 9)),
                new Lotto(Set.of(7, 8, 9, 10, 11, 12))
        );
        Lotto lastWeekWinningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        WinningStatistics actual = WinningStatistics.of(lottos, lastWeekWinningLotto);

        assertThat(actual).isEqualTo(winningStatistics);
    }

    @DisplayName("주어진 당첨정보와 일치하는 당첨정보 수를 반환한다.")
    @Test
    void matches() {
        int actual = winningStatistics.countSame(WinningInformation.SIX_MATCHES);

        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("수익률을 반환한다.")
    @Test
    void calculateYield() {
        BigDecimal actual = winningStatistics.calculateYield(BigDecimal.valueOf(14000));

        assertThat(actual).isEqualTo(BigDecimal.valueOf(285714.64));
    }
}