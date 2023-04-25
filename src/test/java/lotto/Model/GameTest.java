package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    @DisplayName("game 시 ticket 개수 일치")
    public void game_count() {
        int expected = 14;

        Game game = new Game(expected);
        int actual = game.allTickets().size();

        assertThat(actual).isEqualTo(expected);
    }
}