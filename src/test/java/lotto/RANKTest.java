package lotto;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RANKTest {
    @Test
    void 당첨_테스트() {
        // given
        // when
        Optional<RANK> one = RANK.findWinningPrize(1, false);
        Optional<RANK> two = RANK.findWinningPrize(2, false);
        Optional<RANK> three = RANK.findWinningPrize(3, false);
        Optional<RANK> four = RANK.findWinningPrize(4, false);
        Optional<RANK> five = RANK.findWinningPrize(5, false);
        Optional<RANK> fiveBonus = RANK.findWinningPrize(5, true);
        Optional<RANK> six = RANK.findWinningPrize(6, false);
        // then
        assertThat(one).isNotPresent();
        assertThat(two).isNotPresent();
        assertThat(three).isPresent().get().isEqualTo(RANK.THREE);
        assertThat(four).isPresent().get().isEqualTo(RANK.FOUR);
        assertThat(five).isPresent().get().isEqualTo(RANK.FIVE);
        assertThat(fiveBonus).isPresent().get().isEqualTo(RANK.FIVE_BONUS);
        assertThat(six).isPresent().get().isEqualTo(RANK.SIX);
    }

}
