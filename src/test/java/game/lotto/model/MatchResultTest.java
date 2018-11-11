package game.lotto.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {

    private MatchResult matchResult;

    @Before
    public void setup() {
        matchResult = new MatchResult();
    }

    @Test
    public void 매치_추가하기() {
        final Rank rank = Rank.SECOND;
        final Match input = new Match(rank);
        final int beforeCount = matchResult.getMatch(rank).getCount();

        matchResult.plus(input);

        Match match = matchResult.getMatch(rank);
        assertThat(match.getCount()).isEqualTo(beforeCount + 1);
    }

}