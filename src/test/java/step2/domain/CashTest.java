package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Cash;
import step2.exception.InvalidPriceException;

public class CashTest {

  @ParameterizedTest
  @CsvSource(value = {"2000,1500,500", "3000,1000,2000"})
  @DisplayName("제대로 구입액만큼 출금하는지 테스트")
  void validWithdrawalTest(int sellerMoney, int product, int remainMoney){
    // given
    Cash sellerWallet = new Cash(sellerMoney);
    Cash productPrice = new Cash(product);
    Cash remainWallet = new Cash(remainMoney);

    Assertions.assertThat(sellerWallet.withdrawal(productPrice)).isEqualTo(remainWallet);
  }

  @ParameterizedTest
  @CsvSource(value = {"1199,1200", "100,101", "1000, 1001"})
  @DisplayName("유효하지 않은 금액으로 출금이 불가능한지 테스트")
  void invalidWithdrawalTest(int sellerMoney, int product){
    Cash sellerWallet = new Cash(sellerMoney);
    Cash productPrice = new Cash(product);

    Assertions.assertThatThrownBy(() -> sellerWallet.withdrawal(productPrice))
      .isInstanceOf(InvalidPriceException.class)
      .hasMessage("구매를 위한 출금을 할 수 없습니다.");
  }

  @ParameterizedTest
  @CsvSource(value = {"1000,1000,true", "1000,1001,false"})
  @DisplayName("구매할 제품의 가격과의 비교를 제대로 하는지 확인")
  void checkGreatEqualTest(int seller, int product, boolean result){
    Cash sellerWallet = new Cash(seller);
    Cash productPrice = new Cash(product);

    Assertions.assertThat(sellerWallet.isGreaterEqualProductPrice(productPrice)).isEqualTo(result);
  }
}
