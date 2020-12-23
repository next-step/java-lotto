package com.ssabae.nextstep.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ssabae.nextstep.lotto.domain.Money;
import com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator.LottoTicketGenerator;
import com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator.TestLottoTicketGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
class LottoTicketMachineTest {

    private final LottoTicketGenerator generator = new TestLottoTicketGenerator();
    private final LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(generator);

    @Test
    void buyTest() {
        LottoTickets lottoTickets = lottoTicketMachine.buy(Money.won(13000L), Collections.emptyList());
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        assertThat(lottoTicketList.size()).isEqualTo(13);
    }
}
