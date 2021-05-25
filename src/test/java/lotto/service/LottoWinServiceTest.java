package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinServiceTest {

    private LottoWinService service;
    private LottoTickets lottoTickets;
    private LottoNumbers winNumbers;

    @BeforeEach
    void setUp() {
        service = new LottoWinService();

        LottoTicket ticket1 = new LottoTicket(new LottoNumbers(Stream.of(8, 21, 23, 41, 42, 43).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket2 = new LottoTicket(new LottoNumbers(Stream.of(3, 5, 11, 16, 32, 38).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket3 = new LottoTicket(new LottoNumbers(Stream.of(7, 11, 16, 35, 36, 44).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket4 = new LottoTicket(new LottoNumbers(Stream.of(1, 8, 11, 31, 41, 42).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket5 = new LottoTicket(new LottoNumbers(Stream.of(13, 14, 16, 38, 42, 45).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket6 = new LottoTicket(new LottoNumbers(Stream.of(7, 11, 30, 40, 42, 43).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket7 = new LottoTicket(new LottoNumbers(Stream.of(2, 13, 22, 32, 38, 45).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket8 = new LottoTicket(new LottoNumbers(Stream.of(23, 25, 33, 36, 39, 41).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket9 = new LottoTicket(new LottoNumbers(Stream.of(1, 3, 5, 14, 22, 45).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket10 = new LottoTicket(new LottoNumbers(Stream.of(5, 9, 38, 41, 43, 44).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket11 = new LottoTicket(new LottoNumbers(Stream.of(2, 8, 9, 18, 19, 21).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket12 = new LottoTicket(new LottoNumbers(Stream.of(13, 14, 18, 21, 23, 35).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket13 = new LottoTicket(new LottoNumbers(Stream.of(17, 21, 29, 37, 42, 45).map(LottoNumber::of).collect(Collectors.toSet())));
        LottoTicket ticket14 = new LottoTicket(new LottoNumbers(Stream.of(3, 8, 27, 30, 35, 44).map(LottoNumber::of).collect(Collectors.toSet())));

        winNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet()));

        // when
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(ticket1);
        lottoTicketList.add(ticket2);
        lottoTicketList.add(ticket3);
        lottoTicketList.add(ticket4);
        lottoTicketList.add(ticket5);
        lottoTicketList.add(ticket6);
        lottoTicketList.add(ticket7);
        lottoTicketList.add(ticket8);
        lottoTicketList.add(ticket9);
        lottoTicketList.add(ticket10);
        lottoTicketList.add(ticket11);
        lottoTicketList.add(ticket12);
        lottoTicketList.add(ticket13);
        lottoTicketList.add(ticket14);
        lottoTickets = new LottoTickets(lottoTicketList);
    }

    @Test
    @DisplayName("당첨조회 - 등수갯수")
    void rankCount() {
        // given when
        LottoRanks lottoRanks = service.inquiryWin(lottoTickets, winNumbers, LottoNumber.of(34));

        // then
        assertThat(lottoRanks.count(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(lottoRanks.count(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoRanks.count(LottoRank.THIRD)).isEqualTo(0);
        assertThat(lottoRanks.count(LottoRank.SECOND)).isEqualTo(0);
        assertThat(lottoRanks.count(LottoRank.FIRST)).isEqualTo(0);
        assertThat(lottoRanks.count(LottoRank.LOSE)).isEqualTo(13);
    }

    @Test
    @DisplayName("당첨조회 - 2등")
    void rank_second() {
        // given when
        LottoNumbers winNumbers = new LottoNumbers(Stream.of(7, 11, 30, 40, 42, 45).map(LottoNumber::of).collect(Collectors.toSet()));
        LottoRanks lottoRanks = service.inquiryWin(lottoTickets, winNumbers, LottoNumber.of(43));

        // then
        assertThat(lottoRanks.count(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨조회 - 수익률")
    void totalReturnRate() {
        // given when
        LottoRanks lottoRanks = service.inquiryWin(lottoTickets, winNumbers, LottoNumber.of(34));

        // then
        assertThat(lottoRanks.totalReturnRate()).isEqualTo(0.35);
    }

}