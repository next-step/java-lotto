package lotto;

import lotto.game.Rank;
import lotto.game.Round;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;

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

    @Test
    void result() {
        Round round = new Round(3, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        EnumMap<Rank, Integer> result = round.getResult(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result.get(Rank.FIRST_WIN)).isEqualTo(3);
    }

    @Test
    void totalAward() {
        Round round = new Round(3, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        long totalAward = round.totalAward(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(totalAward).isEqualTo(2000000000L * 3);
    }
}
