package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.nextstep.lotto.domain.LottoTicketFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsFactoryTest {
    @DisplayName("수동으로 구매한 LottoTickets와 원금을 인자로 받아서 나머지를 자동으로 구매한 LottoTickeets를 반환한다.")
    @Test
    void createAutoByRemainedMoney() {
        Money originalMoney = new Money(10000L);
        LottoTickets staticBoughtLottoTickets = new LottoTickets(
                Arrays.asList(LOTTO_TICKET_123456, LOTTO_TICKET_234567));
        int expectedSize = 10;

        LottoTickets lottoTickets = LottoTicketsFactory.creatAutoByRemainedMoney(
                originalMoney, staticBoughtLottoTickets);

        assertThat(lottoTickets.size()).isEqualTo(expectedSize);
    }
}
