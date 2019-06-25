package lotto;

import lotto.strategy.LottoOrderedStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private int INPUT_PURCHASED_PRICE = 3000;

    private Lotto       lotto;
    private LottoTicket ticket;
    private List<LottoTicket> tickets;
    private List<Integer> orderedNumbers;

    @BeforeEach
    void setUp() {
        orderedNumbers = new LottoOrderedStrategy().generate();
        lotto = new Lotto(INPUT_PURCHASED_PRICE);
        ticket = new LottoTicket(orderedNumbers);
        tickets = lotto.generate(new LottoOrderedStrategy());
    }

    @Test
    void 구입금액만큼_로또를_발급받는다() {
        assertThat(tickets.size()).isEqualTo(3);
    }

    @Test
    void 발급한_로또는_숫자가_6개다() {
        assertThat(ticket.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 티켓뭉치에서_티켓을_포함한다() {
        assertThat(tickets).contains(ticket);
    }

    @Test
    void 일치한_숫자를_체크한다() {
        LottoResult result = lotto.checkWin(ticket, tickets);

        assertThat(result.numOf(6)).isEqualTo(3);
    }
}
