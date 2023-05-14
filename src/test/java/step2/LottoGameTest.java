package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    LottoGame lottoGame = new LottoGame();

    @Test
    void 로또_n장() {
        List<Ticket> tickets = lottoGame.makeTickets(7000);
        assertThat(tickets).hasSize(7);
    }

}
