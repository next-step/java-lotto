package lotto;

import lotto.domain.BuyableCount;
import lotto.domain.CashPayments;
import lotto.view.LottoPayment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaymentTest {
    @Test
    @DisplayName("구매 횟수를 구한다.")
    void getBuyableCountTest() {
        //Given
        LottoPayment lottoPayment = new LottoPayment();
        //When
        BuyableCount buyableCount = lottoPayment.getBuyableCount(new CashPayments(5000));
        //Then
        Assertions.assertThat(buyableCount.isEqualsTo(5));
    }
}
