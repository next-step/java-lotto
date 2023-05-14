package step2;

import org.junit.jupiter.api.Test;
import step2.view.Winner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    LottoGame lottoGame = new LottoGame();
    /*List<Integer> ticket = Arrays.asList(1, 3, 5, 14, 22, 45);
    List<Integer> winningTicket = Arrays.asList(1, 2, 3, 4, 5, 6);*/

    @Test
    void 로또_n장() {

        List<Ticket> tickets = lottoGame.makeTickets(7000);
        assertThat(tickets).hasSize(7);
    }

}
