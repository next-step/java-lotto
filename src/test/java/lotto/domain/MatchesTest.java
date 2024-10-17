package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchesTest {
    @Test
    void 당첨() {
        Matches matches = new Matches(List.of(1, 2, 3, 4, 5, 6));
      int winningCount = (int) matches.countMatches.stream()
              .filter(match -> 1 == match)
              .count();
      assertThat(new Winning(1, winningCount)).isEqualTo(new Winning(1, 1));
    }
}