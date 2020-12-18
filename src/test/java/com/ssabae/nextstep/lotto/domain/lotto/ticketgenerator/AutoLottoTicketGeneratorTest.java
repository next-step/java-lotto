package com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator;

import static org.assertj.core.api.Assertions.assertThat;

import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;
import com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator.AutoLottoTicketGenerator;
import com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator.LottoTicketGenerator;
import org.junit.jupiter.api.Test;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
class AutoLottoTicketGeneratorTest {

    private LottoTicketGenerator generator = new AutoLottoTicketGenerator();

    @Test
    void subListTest() {
        LottoTicket ticket = generator.generate();
        assertThat(ticket.getNumbers().length).isEqualTo(6);
    }

}
