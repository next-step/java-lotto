package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.InvalidPriceException;

public class CashTest {

  @ParameterizedTest
  @CsvSource(value = {"2000,1000", "3000,2000"})
  @DisplayName("제대로 로또 구입액만큼 출금하는지 테스트")
  void validWithdrawalTest(Long sellerMoney, Long remainMoney) {
    // given
    Cash sellerWallet = new Cash(sellerMoney);
    Cash remainWallet = new Cash(remainMoney);

    Assertions.assertThat(sellerWallet.withdrawal()).isEqualTo(remainWallet);
  }

  @ParameterizedTest
  @ValueSource(longs = {999, 988, 1})
  @DisplayName("유효하지 않은 금액으로 출금이 불가능한지 테스트")
  void invalidWithdrawalTest(Long sellerMoney) {
    Cash sellerWallet = new Cash(sellerMoney);

    Assertions.assertThatThrownBy(sellerWallet::withdrawal)
      .isInstanceOf(InvalidPriceException.class)
      .hasMessage("구매를 위한 출금을 할 수 없습니다.");
  }

  @ParameterizedTest
  @ValueSource(longs = {-1, -999})
  @DisplayName("0원 미만은 생성 불가능")
  void invalidConstructingTest(Long sellerMoney) {
    Assertions.assertThatThrownBy(() -> new Cash(sellerMoney))
      .isInstanceOf(InvalidPriceException.class)
      .hasMessage("0원 미만의 금액은 지원하지 않습니다.");
  }


  @ParameterizedTest
  @CsvSource(value = {"1000,1000,true", "1000,1001,false"})
  @DisplayName("구매할 제품의 가격과의 비교를 제대로 하는지 확인")
  void checkGreatEqualTest(Long seller, Long product, boolean result) {
    Cash sellerWallet = new Cash(seller);
    Cash productPrice = new Cash(product);

    Assertions.assertThat(sellerWallet.isGreaterEqualProductPrice(productPrice)).isEqualTo(result);
  }
}
