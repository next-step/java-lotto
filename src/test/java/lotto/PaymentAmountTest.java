package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentAmountTest {

  @Test
  void PaymentAmount_생성_성공() {
    assertDoesNotThrow(() -> new PaymentAmount(1));
  }

  @ParameterizedTest
  @ValueSource(ints = {1000, 2000, 10000})
  void purchaseLotto_성공(int lottoPrice) {
    PaymentAmount paymentAmount = new PaymentAmount(lottoPrice);

    int purchaseAmount = paymentAmount.purchaseLotto(lottoPrice);

    assertThat(purchaseAmount).isEqualTo(1);
  }

  @Test
  void PaymentAmount_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new LottoNumber(-1));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 10000})
  void purchaseLotto_실패(int lottoPrice) {
    PaymentAmount paymentAmount = new PaymentAmount(1000);

    assertThrows(IllegalArgumentException.class, () -> paymentAmount.purchaseLotto(lottoPrice));
  }

}
