package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.WinningInformation.*;
import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        List<WinningInformation> winningInformations = List.of(
                SIX_MATCHES,
                SIX_MATCHES,
                THREE_MATCHES,
                FIVE_AND_BONUS_MATCHES,
                NOT_MATCHES
        );
        winningStatistics = new WinningStatistics(winningInformations);
    }

    @DisplayName("로또리스트, 지난주 당첨 로또, 보너스볼로 로또통계를 생성할 수 있다.")
    @Test
    void of() {
        List<Lotto> lottos = List.of(
                createLotto(1, 6),
                createLotto(1, 6),
                createLotto(4, 9),
                createLotto(2, 7),
                createLotto(7, 12)
        );
        Lotto lastWeekWinningLotto = createLotto(1, 6);
        BonusBall bonusBall = new BonusBall("7", lastWeekWinningLotto);

        WinningStatistics actual = WinningStatistics.of(lottos, lastWeekWinningLotto, bonusBall);

        assertThat(actual).isEqualTo(winningStatistics);
    }

    @DisplayName("주어진 당첨정보와 일치하는 당첨정보 수를 반환한다.")
    @Test
    void matches() {
        int actual = winningStatistics.countSame(SIX_MATCHES);

        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("수익률을 반환한다.")
    @Test
    void calculateYield() {
        BigDecimal actual = winningStatistics.calculateYield(new Money(14000));

        assertThat(actual).isEqualTo(new BigDecimal("287857.50"));
    }

    private Lotto createLotto(int startInclusive, int endInclusive) {
        return new Lotto(
                IntStream.rangeClosed(startInclusive, endInclusive)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toSet())
        );
    }
}
