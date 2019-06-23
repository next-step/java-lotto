package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.LottoPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceTest {
    @Test
    @DisplayName("구매 가능한 횟수를 구한다.")
    void getBuyableCountTest() {
        //Given
        LottoPrice lottoPrice = new LottoPrice();
        //When
        int buyableCount = lottoPrice.getBuyableCount(10000);
        //Then
        Assertions.assertThat(buyableCount).isEqualTo(10);
    }
    
    @Test
    @DisplayName("1,000 원보다 적은 값이 들어오면 구매가 불가능하다.")
    void getBuyableCountExceptionTest() {
        //Given
        LottoPrice lottoPrice = new LottoPrice();
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> lottoPrice.getBuyableCount(999))
          .withMessage(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
        
    }
}
