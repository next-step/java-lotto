package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("Lotto Ticket 생성")
    @Test
    void createLottoTicket() {
        final List<String> lottoNumbers = List.of(
                "1,2,3,4,5,6",
                "12,23,34,45,26,37",
                "3 ,4 , 5 ,  6 ,  7 , 8"
        );

        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        assertThat(lottoTicket).isNotNull();
    }

}
