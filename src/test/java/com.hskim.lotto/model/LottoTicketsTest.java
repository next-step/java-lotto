package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        NumberMaker numberMaker = new FixedNumberMaker();
        PurchasePrice purchasePrice = new PurchasePrice(14000);
        LottoTickets lottoTickets = new LottoTickets(purchasePrice, numberMaker);

        // when & then
        assertThat(lottoTickets).isEqualTo(new LottoTickets(purchasePrice, numberMaker));
    }

    @DisplayName("getTotalTicketPrice() 테스트")
    @Test
    void getTotalTicketPrice() {
        // given
        int expense = 14000;
        NumberMaker numberMaker = new FixedNumberMaker();
        PurchasePrice purchasePrice = new PurchasePrice(expense);
        LottoTickets lottoTickets = new LottoTickets(purchasePrice, numberMaker);

        // when
        int result = lottoTickets.getTotalTicketPrice();

        // then
        assertThat(result).isEqualTo(expense);
    }

    @DisplayName("getWinTableList() 테스트")
    @Test
    void getWinTableList() {
        // given
        LottoTickets lottoTickets = new LottoTickets(makeLottoTickets());
        LottoWinningTicket winningTicket = new LottoWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
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
                LottoWinTable.SECOND_PLACE,
                LottoWinTable.THIRD_PLACE,
                LottoWinTable.FOURTH_PLACE,
                LottoWinTable.FOURTH_PLACE,
                LottoWinTable.FOURTH_PLACE
        );
    }
}
