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
    public void 일치_3개_숫자_증가() {
        matchResult.incrementMatch(3);

        assertThat(matchResult.getMatch(MatchType.MATCH_3).getCount()).isEqualTo(1);

        matchResult.incrementMatch(3);

        assertThat(matchResult.getMatch(MatchType.MATCH_3).getCount()).isEqualTo(2);
    }

    @Test
    public void 일치_4개_숫자_증가() {
        matchResult.incrementMatch(4);

        assertThat(matchResult.getMatch(MatchType.MATCH_4).getCount()).isEqualTo(1);

        matchResult.incrementMatch(4);

        assertThat(matchResult.getMatch(MatchType.MATCH_4).getCount()).isEqualTo(2);
    }

    @Test
    public void 일치_5개_숫자_증가() {
        matchResult.incrementMatch(5);

        assertThat(matchResult.getMatch(MatchType.MATCH_5).getCount()).isEqualTo(1);

        matchResult.incrementMatch(5);

        assertThat(matchResult.getMatch(MatchType.MATCH_5).getCount()).isEqualTo(2);
    }

    @Test
    public void 일치_6개_숫자_증가() {
        matchResult.incrementMatch(6);

        assertThat(matchResult.getMatch(MatchType.MATCH_6).getCount()).isEqualTo(1);

        matchResult.incrementMatch(6);

        assertThat(matchResult.getMatch(MatchType.MATCH_6).getCount()).isEqualTo(2);
    }

}