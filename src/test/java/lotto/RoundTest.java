package lotto;

import lotto.game.Rank;
import lotto.game.Round;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    @Test
    void create() {
        Round round = new Round(3, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(round.gameCount()).isEqualTo(3);

        round.getGames().forEach(game -> {
            Rank result = game.win(Arrays.asList(1, 2, 3, 4, 5, 6));
            assertThat(result).isEqualTo(Rank.FIRST_WIN);
        });
    }
}
