package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    public void 맞은_개수에_따른_등수를_가져온다() {
        assertThat(Prize.matchPrize(6)).isEqualByComparingTo(Prize.FIRST_PRIZE);
        assertThat(Prize.matchPrize(5)).isEqualByComparingTo(Prize.SECOND_PRIZE);
        assertThat(Prize.matchPrize(4)).isEqualByComparingTo(Prize.THIRD_PRIZE);
        assertThat(Prize.matchPrize(3)).isEqualByComparingTo(Prize.FOURTH_PRIZE);

        assertThat(Prize.matchPrize(2)).isEqualByComparingTo(Prize.NONE);
    }
}