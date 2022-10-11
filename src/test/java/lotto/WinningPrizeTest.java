package lotto;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningPrizeTest {
    @Test
    void 당첨_테스트() {
        // given
        // when
        Optional<WinningPrize> one = WinningPrize.findWinningPrize(1);
        Optional<WinningPrize> two = WinningPrize.findWinningPrize(2);
        Optional<WinningPrize> three = WinningPrize.findWinningPrize(3);
        Optional<WinningPrize> four = WinningPrize.findWinningPrize(4);
        Optional<WinningPrize> five = WinningPrize.findWinningPrize(5);
        Optional<WinningPrize> six = WinningPrize.findWinningPrize(6);
        // then
        assertThat(one).isNotPresent();
        assertThat(two).isNotPresent();
        assertThat(three).isPresent().get().isEqualTo(WinningPrize.THREE);
        assertThat(four).isPresent().get().isEqualTo(WinningPrize.FOUR);
        assertThat(five).isPresent().get().isEqualTo(WinningPrize.FIVE);
        assertThat(six).isPresent().get().isEqualTo(WinningPrize.SIX);
    }
}
