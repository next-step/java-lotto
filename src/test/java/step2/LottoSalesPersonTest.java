package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoSalesPersonTest {

    @Test
    @DisplayName("입력받은 금액을 바탕으로 구입할 티켓 장수 계산하는 테스트")
    void howManyBuyLotto() {
        // given
        int purchasingAmount = 5_000;
        LottoSalesPerson lottoSalesPerson = new LottoSalesPerson(new PurchaseTest(purchasingAmount));

        // when
        int actual = lottoSalesPerson.howManyBuyLotto();

        // then
        assertEquals(5, actual);
    }
}
