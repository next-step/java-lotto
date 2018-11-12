package game.lotto.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {

    private Match match;

    @Before
    public void setup() {
        this.match = new Match(Rank.FIFTH);
    }

    @Test
    public void 매치수_증가하기() {
        final int beforeCount = match.getCount();

        match.plusCount();

        assertThat(match.getCount()).isEqualTo(beforeCount + 1);
    }

    @Test
    public void 총_상금액() {
        final int incrementCount = 3;
        for (int i = 0; i < 3; i++) {
            match.plusCount();
        }

        assertThat(match.getTotalPrize()).isEqualTo(match.getRank().getPrize() * incrementCount);
    }

}