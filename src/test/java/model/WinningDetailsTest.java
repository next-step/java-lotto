package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class WinningDetailsTest {

    @Test
    void 당첨_내역_테스트() {
        // given
        final Lottos lottos = new Lottos(List.of(
                // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                // 3개 일치
                new Lotto(List.of(1, 2, 4, 6, 7, 8)),
                // 0개 일치
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber lottoNumber = new LottoNumber(7);
        final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, lottoNumber);

        // when
        final WinningDetails winningDetails = new WinningDetails();
        winningDetails.makeWinningDetails(lottos, lottoWinningNumber);

        // then
        assertAll(
                () -> assertThat(winningDetails.getWinningCount(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(winningDetails.getWinningCount(Rank.SECOND)).isEqualTo(0),
                () -> assertThat(winningDetails.getWinningCount(Rank.THIRD)).isEqualTo(0),
                () -> assertThat(winningDetails.getWinningCount(Rank.FOURTH)).isEqualTo(1),
                () -> assertThat(winningDetails.getWinningCount(Rank.FIFTH)).isEqualTo(0),
                () -> assertThat(winningDetails.getWinningCount(Rank.NONE)).isEqualTo(1)
        );
    }

    @Test
    void 수익률_계산_테스트() {
        // given
        final LottoAmount lottoAmount = new LottoAmount(10000);
        final Map<Rank, Integer> details = new HashMap<>() {{
            put(Rank.FIRST, 1);
            put(Rank.FOURTH, 1);
            put(Rank.NONE, 3);
        }};
        final WinningDetails winningDetails = new WinningDetails(details);

        // when
        final BigDecimal profit = winningDetails.calculateProfit(lottoAmount);

        // then
        assertThat(profit).isEqualTo(new BigDecimal("200005.00"));
    }
}
