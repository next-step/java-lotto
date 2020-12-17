package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicketGenerator;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicketMachine;
import com.ssabae.nextstep.lotto.domain.lotto.TestLottoTicketGenerator;
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
        List<LottoTicket> ticket = lottoTicketMachine.buy(Money.won(13000L));
        assertThat(ticket.size()).isEqualTo(13);
    }
}
