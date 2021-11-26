package com.kakao.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓 그룹을 생성할 수 있다. 중복된 번호를 가진 로또 티켓도 포함이 가능하다.")
    void getLottoTickets() {
        LottoTicket lottoTicket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket3 = LottoTicket.of(Arrays.asList(1, 3, 7, 8, 9, 10));
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3));
        assertThat(lottoTickets.getLottoTickets()).containsExactly(lottoTicket1, lottoTicket2, lottoTicket3);
    }

    @Test
    @DisplayName("이미 생성된 로또 티켓 그룹은 변경이 불가능하다.")
    void getLottoTicketsUnmodified() {
        LottoTicket lottoTicket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = new LottoTickets(Collections.singletonList(lottoTicket1));
        assertThrows(UnsupportedOperationException.class,
                () -> lottoTickets.getLottoTickets().add(LottoTicket.of(Arrays.asList(1, 3, 7, 8, 9, 10))));
    }

    @Test
    @DisplayName("로또 티켓 그룹끼리 병합이 가능하다.")
    void concat() {
        LottoTicket lottoTicket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = LottoTicket.of(Arrays.asList(1, 3, 7, 8, 9, 10));

        LottoTickets lottoTicketGroup = new LottoTickets(Collections.singletonList(lottoTicket1));
        LottoTickets addingLottoTicketGroup = new LottoTickets(Collections.singletonList(lottoTicket2));

        LottoTickets mergedTicket = lottoTicketGroup.createMergedTicket(addingLottoTicketGroup);

        assertThat(mergedTicket.getLottoTickets()).containsExactly(lottoTicket1, lottoTicket2);
    }
}
