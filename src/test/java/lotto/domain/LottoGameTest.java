package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @Test
    void 로또_구입() {
        int money = 14000;
        LottoGame lottoGame = new LottoGame();
        List<LottoTicket> tickets = lottoGame.buyLottoTicket(money);
        assertThat(tickets).hasSize(14);
    }


}
