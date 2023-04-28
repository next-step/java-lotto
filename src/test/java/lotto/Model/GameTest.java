package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("addTicket 정상 확인")
    public void addTicket_count() {
        List<Integer> inputNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket inputTicket = new Ticket(inputNumber);

        List<Ticket> expected = List.of(inputTicket);

        Game game = new Game(0);
        game.addTicket(inputTicket);
        List<Ticket> actual = game.allTickets();

        assertThat(actual).isEqualTo(expected);
    }
}