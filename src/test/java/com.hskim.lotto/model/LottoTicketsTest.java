package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LottoNumberMaker numberMaker = new FixedLottoNumberMaker();
        PurchasePrice purchasePrice = new PurchasePrice(14000);
        LottoTickets lottoTickets = new LottoTickets(LottoMachine.automaticIssuance(purchasePrice, numberMaker));

        // when & then
        assertThat(lottoTickets).isEqualTo(new LottoTickets(LottoMachine.automaticIssuance(purchasePrice, numberMaker)));
    }

    @DisplayName("getTotalTicketPrice() 테스트 - 티켓 총가격 로직 검증")
    @Test
    void getTotalTicketPrice() {
        // given
        int expense = 14000;
        LottoNumberMaker numberMaker = new FixedLottoNumberMaker();
        PurchasePrice purchasePrice = new PurchasePrice(expense);
        LottoTickets lottoTickets = new LottoTickets(LottoMachine.automaticIssuance(purchasePrice, numberMaker));

        // when
        int result = lottoTickets.getTotalTicketPrice();

        // then
        assertThat(result).isEqualTo(expense);
    }

    @DisplayName("mergeTickets() 테스트 - 다른 LottoTickets객체를 받아 lottoTickets인스턴스가 합쳐진 객체 반환 테스트")
    @Test
    void mergeTickets() {
        // given
        LottoTickets lottoTickets = new LottoTickets(makeLottoTickets());
        List<LottoTicket> lottoTicketList = makeLottoTickets();
        makeLottoTickets().addAll(makeLottoTickets());
        LottoTickets expected = new LottoTickets(lottoTicketList);

        // when
        LottoTickets result = lottoTickets.mergeTickets(new LottoTickets(makeLottoTickets()));

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("getWinTableList() 테스트 - 티켓들에 해당하는 당첨 등수 list를 구하는 로직 검증")
    @Test
    void getWinTableList() {
        // given
        LottoTickets lottoTickets = new LottoTickets(makeLottoTickets());
        LottoWinningTicket winningTicket = new LottoWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        List<LottoWinTable> expected = makeWinTables();

        // when
        List<LottoWinTable> winTables = lottoTickets.getWinTableList(winningTicket);

        // then
        assertThat(winTables).isEqualTo(expected);
    }

    private List<LottoTicket> makeLottoTickets() {

        return Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 45)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 44, 45)),
                new LottoTicket(Arrays.asList(1, 2, 3, 43, 44, 45)),
                new LottoTicket(Arrays.asList(1, 2, 3, 42, 44, 45)),
                new LottoTicket(Arrays.asList(1, 2, 3, 41, 44, 45))
        );
    }

    private List<LottoWinTable> makeWinTables() {

        return Arrays.asList(
                LottoWinTable.FIRST_PLACE,
                LottoWinTable.THIRD_PLACE,
                LottoWinTable.FOURTH_PLACE,
                LottoWinTable.FIFTH_PLACE,
                LottoWinTable.FIFTH_PLACE,
                LottoWinTable.FIFTH_PLACE
        );
    }
}
