package lotto;

import lotto.domain.Match;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MatchTest {

    @Test
    void Enum_matchCount() {
        Match match2 = Match.valueOf(2);
        Match match3 = Match.valueOf(3);

        assertThat(match2).isEqualTo(Match.BLANK);
        assertThat(match3).isEqualTo(Match.THREEMATCH);
    }
}