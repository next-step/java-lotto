package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    @Test
    void 로또_통계() {
        Match match = new Match(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7))), "1, 2, 3, 4, 5, 6");
        assertThat(match.winnings()).isEqualTo(new Winnings(List.of(new Winning(3, 0), new Winning(4, 0), new Winning(5, 1), new Winning(6, 1))));
    }
}