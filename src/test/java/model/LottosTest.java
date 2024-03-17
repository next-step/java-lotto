package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class LottosTest {

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
        final Map<WinningPrice, Integer> winningDetails = lottos.makeWinningDetails(winningNumbers);

        // then
        assertAll(
                () -> assertThat(winningDetails.get(WinningPrice.FIRST)).isEqualTo(1),
                () -> assertThat(winningDetails.get(WinningPrice.SECOND)).isEqualTo(0),
                () -> assertThat(winningDetails.get(WinningPrice.THIRD)).isEqualTo(1),
                () -> assertThat(winningDetails.get(WinningPrice.FOURTH)).isEqualTo(0),
                () -> assertThat(winningDetails.get(WinningPrice.NONE)).isEqualTo(1)
        );
    }
}
