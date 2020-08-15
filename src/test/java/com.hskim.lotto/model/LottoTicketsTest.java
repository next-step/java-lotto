package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        NumberMaker numberMaker = new FixedNumberMaker();
        PurchasePrice purchasePrice = new PurchasePrice("14000");
        LottoTickets lottoTickets = new LottoTickets(purchasePrice, numberMaker);

        // when & then
        assertThat(lottoTickets).isEqualTo(new LottoTickets(purchasePrice, numberMaker));
    }

    @DisplayName("getTotalTicketPrice() 테스트")
    @Test
    void getTotalTicketPrice() {
        // given
        String expense = "14000";
        NumberMaker numberMaker = new FixedNumberMaker();
        PurchasePrice purchasePrice = new PurchasePrice(expense);
        LottoTickets lottoTickets = new LottoTickets(purchasePrice, numberMaker);

        // when
        String result = lottoTickets.getTotalTicketPrice().toString();

        // then
        assertThat(result).isEqualTo(expense);
    }
}
