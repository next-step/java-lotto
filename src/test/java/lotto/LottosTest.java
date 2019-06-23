package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {
    private Lottos lottos;
    
    @BeforeEach
    void setUp() { 
        lottos = new Lottos();
    }
    
    @Test
    @DisplayName("금액이 1,000원 미만이면 구매할 수 없다.")
    void buyUnderMinimumPriceTest() {
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> lottos.buyLottos(999))
          .withMessage(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
    }

    @Test
    @DisplayName("입력한 금액과 맞는 매수의 로또를 구매한다.")
    void boughtLottosCountTest() {
        //Given
        int cashPayment = 5000;
        //When
        List<Lotto> boughtLottos = lottos.buyLottos(cashPayment);
        //Then
        Assertions.assertThat(boughtLottos.size()).isEqualTo(5);
    }
}
