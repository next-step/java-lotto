package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchingResultTest {
    @Test
    public void supports_true() {
        MatchingResult result = new MatchingResult(Rank.FIFTH);
        assertThat(result.supports(Rank.FIFTH)).isTrue();
    }

    @Test
    public void supports_false() {
        MatchingResult result = new MatchingResult(Rank.FIFTH);
        assertThat(result.supports(Rank.FOURTH)).isFalse();
    }

    @Test
    public void match() {
        MatchingResult result = new MatchingResult(Rank.FIFTH);
        assertThat(result.match()).isEqualTo(1);
    }
}
