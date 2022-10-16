package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        List<WinningInformation> winningInformations = List.of(
                WinningInformation.from(6),
                WinningInformation.from(6),
                WinningInformation.from(3),
                WinningInformation.from(0)
        );
        winningStatistics = new WinningStatistics(winningInformations);
    }

    @DisplayName("로또리스트와 지난주 당첨 로또로 로또통계를 생성할 수 있다.")
    @Test
    void of() {
        List<Lotto> lottos = List.of(
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toSet())),
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toSet())),
                new Lotto(IntStream.rangeClosed(4, 9)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toSet())),
                new Lotto(IntStream.rangeClosed(7, 12)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toSet()))
        );
        Lotto lastWeekWinningLotto = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet()));

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
        BigDecimal actual = winningStatistics.calculateYield(new Money(14000));

        assertThat(actual).isEqualTo(BigDecimal.valueOf(285714.64));
    }
}
