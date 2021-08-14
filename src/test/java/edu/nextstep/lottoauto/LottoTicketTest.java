package edu.nextstep.lottoauto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @Test
    void create(){
        // given, when
        LottoTicket lottoTicket = LottoTicket.create();

        // then
        assertThat(lottoTicket.size()).isEqualTo(6);
    }
}
