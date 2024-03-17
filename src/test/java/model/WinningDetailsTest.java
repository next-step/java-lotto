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
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 4, 6, 7, 8)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        // when
        final WinningDetails winningDetails = new WinningDetails();
        winningDetails.makeWinningDetails(lottos, winningNumbers);

        // then
        assertAll(
                () -> assertThat(winningDetails.getWinningDetails().get(WinningPrice.FIRST)).isEqualTo(1),
                () -> assertThat(winningDetails.getWinningDetails().get(WinningPrice.SECOND)).isEqualTo(0),
                () -> assertThat(winningDetails.getWinningDetails().get(WinningPrice.THIRD)).isEqualTo(1),
                () -> assertThat(winningDetails.getWinningDetails().get(WinningPrice.FOURTH)).isEqualTo(0),
                () -> assertThat(winningDetails.getWinningDetails().get(WinningPrice.NONE)).isEqualTo(1)
        );
    }

    @Test
    void 수익률_계산_테스트() {
        // given
        final LottoAmount lottoAmount = new LottoAmount(10000);
        final Map<WinningPrice, Integer> details = new HashMap<>() {{
            put(WinningPrice.FIRST, 1);
            put(WinningPrice.FOURTH, 1);
            put(WinningPrice.NONE, 3);
        }};
        final WinningDetails winningDetails = new WinningDetails(details);

        // when
        final BigDecimal profit = winningDetails.calculateProfit(lottoAmount);

        // then
        assertThat(profit).isEqualTo(new BigDecimal("200000.50"));
    }
}
