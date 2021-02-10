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
        final LottoTickets lottoTickets = makeLottoTickets();

        // when
        final int purchaseAmount = lottoTickets.getPurchaseAmount();

        // then
        assertThat(purchaseAmount).isEqualTo(PURCHASE_LOTTO_AMOUNT);
    }

    @DisplayName("3000원 어치 로토티켓을 구매했을 때, 3회가 등록되었는 지 확인하는 테스트")
    @Test
    void getPurchaseCountTest() {
        // given
        final LottoTickets lottoTickets = makeLottoTickets();

        // when
        final int purchaseCount = lottoTickets.getPurchaseCount();

        // then
        assertThat(purchaseCount).isEqualTo(3);
    }

    @DisplayName("3000원 어치 로토티켓을 구매했을 때, 로토 티켓을 꺼내서 3장 인지 확인하는 테스트")
    @Test
    void getLottoTicketsTest() {
        // given
        final LottoTickets lottoTickets = makeLottoTickets();

        // when
        final List<LottoTicket> lottoTicket = lottoTickets.getLottoTickets();

        // then
        assertThat(lottoTicket.size()).isEqualTo(3);
    }

    private LottoTickets makeLottoTickets(){
        final AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();
        final ManualNumbersPicker manualNumbersPicker = new ManualNumbersPicker();
        final Money money = new Money(PURCHASE_LOTTO_AMOUNT);
        final LottoCount lottoCount = new LottoCount(money);
        final Purchase purchase = new LottoPurchase(autoNumbersPicker, manualNumbersPicker, lottoCount);

        return new LottoTickets(purchase);
    }
}