package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchesTest {
    @Test
    void 당첨() {
        Matches matches = new Matches(List.of(1, 2, 3, 4, 5, 6));
        assertThat(matches.winning(1)).isEqualTo(new Winning(1, 1));
    }
}