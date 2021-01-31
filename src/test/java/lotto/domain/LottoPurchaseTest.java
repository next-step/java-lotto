package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {
    private final static int PURCHASE_LOTTO_AMOUNT = 3_000;
    private final static int LOTTO_TICKET_COUNT = 3;

    @DisplayName("복권을 3000원 구매했을 때, amount가 3000원으로 정상적으로 리턴되는 지 확인하는 테스트")
    @Test
    void getAmountTest() {
        //given
        NumberPicker numberPicker = new LottoNumbersPicker();
        Purchase purchase = new LottoPurchase(numberPicker, PURCHASE_LOTTO_AMOUNT);

        //when
        int purchaseAmount = purchase.getAmount();
        //then
        assertThat(purchaseAmount).isEqualTo(PURCHASE_LOTTO_AMOUNT);
    }

    @DisplayName("복권을 3000원 구매했을 때, 복권이 정상적으로 반환되는 지, 확인하는 테스트")
    @Test
    void buyTest() {
        //given
        NumberPicker numberPicker = new LottoNumbersPicker();
        Purchase purchase = new LottoPurchase(numberPicker, PURCHASE_LOTTO_AMOUNT);

        //when
        List<LottoTicket> lottoTickets = purchase.buy();

        //amount
        assertThat(lottoTickets.size()).isEqualTo(LOTTO_TICKET_COUNT);
    }
}