package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {
    private final static int PURCHASE_LOTTO_AMOUNT = 3_000;
    private final static int LOTTO_TICKET_COUNT = 3;

    @DisplayName("복권을 3000원 구매했을 때, amount가 3000원으로 정상적으로 리턴되는 지 확인하는 테스트")
    @Test
    void getAmountTest() {
        //given
        final AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();
        final ManualNumbersPicker manualNumbersPicker = new ManualNumbersPicker();
        final Money money = new Money(PURCHASE_LOTTO_AMOUNT);
        final Purchase purchase = new LottoPurchase(autoNumbersPicker, manualNumbersPicker, money);

        //when
        final int purchaseAmount = purchase.getAmount();
        //then
        assertThat(purchaseAmount).isEqualTo(PURCHASE_LOTTO_AMOUNT);
    }

    @DisplayName("복권을 3000원 구매했을 때, 복권이 정상적으로 반환되는 지, 확인하는 테스트")
    @Test
    void buyTest() {
        //given
        final AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();
        final ManualNumbersPicker manualNumbersPicker = new ManualNumbersPicker();
        final Money money = new Money(PURCHASE_LOTTO_AMOUNT);
        final Purchase purchase = new LottoPurchase(autoNumbersPicker, manualNumbersPicker, money);

        //when
        final List<LottoTicket> lottoTickets = purchase.buy();

        //amount
        assertThat(lottoTickets.size()).isEqualTo(LOTTO_TICKET_COUNT);
    }

    @DisplayName("복권을 3000원 구매했을 때, 수동 1000원과 자동 2000원을 정상적으로 구매했는 지 테스트")
    @Test
    void getPurchaseInformationTest() {
        //given
        final List<String> inputDatas = Arrays.asList("1,2,3,4,5,6");
        final AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();
        final ManualNumbersPicker manualNumbersPicker = new ManualNumbersPicker(inputDatas);
        final Money money = new Money(PURCHASE_LOTTO_AMOUNT);
        final Purchase purchase = new LottoPurchase(autoNumbersPicker, manualNumbersPicker, money);

        //when
        final String purchaseInformation = purchase.toString();

        //then
        assertThat(purchaseInformation).isEqualTo("수동으로 1장, 자동으로 2개를 구매했습니다.");
    }
}