package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoPurchaseTest {

    @DisplayName("자동구입 전략")
    @Test
    void purchase() {
        // given
        LottoPurchase lottoPurchase = new AutoPurchase();
        PurchaseAmount amount = new PurchaseAmount(14_000);

        // when
        List<LottoTicket> lottoTickets = lottoPurchase.purchase(amount);

        // then
        assertThat(lottoTickets).hasSize(14);
    }
}