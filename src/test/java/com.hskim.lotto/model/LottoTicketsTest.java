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
}
