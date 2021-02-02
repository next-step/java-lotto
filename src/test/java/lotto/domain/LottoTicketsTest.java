package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private final static int PURCHASE_LOTTO_AMOUNT = 3_000;

    @DisplayName("3000원 어치 로토티켓을 구매했을 때, 구매한 가격이 3000원인 지 확인하는 테스트")
    @Test
    void getPurchaseAmountTest() {
        // given
        AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();
        ManualNumbersPicker manualNumbersPicker = new ManualNumbersPicker();
        Money money = new Money(PURCHASE_LOTTO_AMOUNT);
        Purchase purchase = new LottoPurchase(autoNumbersPicker, manualNumbersPicker, money);

        LottoTickets lottoTickets = new LottoTickets(purchase);
        // when

        int purchaseAmount = lottoTickets.getPurchaseAmount();

        // then
        assertThat(purchaseAmount).isEqualTo(PURCHASE_LOTTO_AMOUNT);
    }

    @DisplayName("3000원 어치 로토티켓을 구매했을 때, 3회가 등록되었는 지 확인하는 테스트")
    @Test
    void getPurchaseCountTest() {
        // given
        AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();
        ManualNumbersPicker manualNumbersPicker = new ManualNumbersPicker();
        Money money = new Money(PURCHASE_LOTTO_AMOUNT);
        Purchase purchase = new LottoPurchase(autoNumbersPicker, manualNumbersPicker, money);

        LottoTickets lottoTickets = new LottoTickets(purchase);
        // when

        int purchaseCount = lottoTickets.getPurchaseCount();

        // then
        assertThat(purchaseCount).isEqualTo(3);
    }

    @DisplayName("3000원 어치 로토티켓을 구매했을 때, 로토 티켓을 꺼내서 3장 인지 확인하는 테스트")
    @Test
    void getLottoTicketsTest() {
        // given
        AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();
        ManualNumbersPicker manualNumbersPicker = new ManualNumbersPicker();
        Money money = new Money(PURCHASE_LOTTO_AMOUNT);
        Purchase purchase = new LottoPurchase(autoNumbersPicker, manualNumbersPicker, money);

        LottoTickets lottoTickets = new LottoTickets(purchase);
        // when

        List<LottoTicket> lottoTicket = lottoTickets.getLottoTickets();

        // then
        assertThat(lottoTicket.size()).isEqualTo(3);
    }
}