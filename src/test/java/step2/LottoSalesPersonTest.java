package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoSalesPersonTest {

    @Test
    @DisplayName("입력받은 금액을 바탕으로 구입할 티켓 장수 계산하는 테스트")
    void howManyBuyLotto() {
        // given
        int purchasingAmount = 5_000;
        LottoSalesPerson lottoSalesPerson = new LottoSalesPerson(new PurchaseTest(purchasingAmount),
                new AutoLottoNumberGenerator());

        // when
        int actual = lottoSalesPerson.howManyBuyLotto();

        // then
        assertEquals(5, actual);
    }

    @Test
    @DisplayName("로또 장수에 맞춰 로또 발급되었는지 테스트")
    void makeLotto(){
        // given
        int amount = 10_000;
        int expected = amount/1000;

        LottoSalesPerson lottoSalesPerson = new LottoSalesPerson(new PurchaseTest(amount), new AutoLottoNumberGenerator());

        // when
        List<LottoTicket> lottoCollection = lottoSalesPerson.makeLotto(expected);
        int actual = lottoCollection.size();

        // then
        assertEquals(expected, actual);
    }
}
