package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    public void 맞은_개수에_따른_등수를_가져온다() {
        assertThat(Prize.matchPrize(6, false)).isEqualByComparingTo(Prize.FIRST_PRIZE);
        assertThat(Prize.matchPrize(5, true)).isEqualByComparingTo(Prize.SECOND_PRIZE);
        assertThat(Prize.matchPrize(5, false)).isEqualByComparingTo(Prize.THIRD_PRIZE);
        assertThat(Prize.matchPrize(4, false)).isEqualByComparingTo(Prize.FOURTH_PRIZE);
        assertThat(Prize.matchPrize(4, true)).isEqualByComparingTo(Prize.FOURTH_PRIZE);
        assertThat(Prize.matchPrize(3, false)).isEqualByComparingTo(Prize.FIFTH_PRIZE);

        assertThat(Prize.matchPrize(2, false)).isEqualByComparingTo(Prize.NONE);
    }
}