package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CreditTest {

  @Test
  void Credit_생성_성공() {
    assertDoesNotThrow(() -> new Credit(1));
  }

  @ParameterizedTest(name = "{0}으로 Credit을 생성 -> 실패")
  @ValueSource(ints = {-1, 0})
  void Credit_생성_실패(int invalidCredit) {
    assertThrows(IllegalArgumentException.class, () -> new Credit(invalidCredit));
  }

  @ParameterizedTest(name = "상품 가격이 {0}일 때, Credit.purchase() 성공")
  @ValueSource(ints = {1000, 2000, 10000})
  void purchase_성공(int productPrice) {
    Credit credit = new Credit(productPrice);

    int purchaseAmount = credit.purchase(productPrice);

    assertThat(purchaseAmount).isEqualTo(1);
  }

  @ParameterizedTest(name = "상품 가격이 {0}일 때, Credit.purchase() 실패")
  @ValueSource(ints = {-1, 0, 10000})
  void purchase_실패(int lottoPrice) {
    Credit credit = new Credit(1000);

    assertThrows(IllegalArgumentException.class, () -> credit.purchase(lottoPrice));
  }

  @ParameterizedTest(name = "상품의 가격이 {0}일 때, {1}개 살 수 있음")
  @MethodSource("priceAndAmount")
  void calculatePurchaseAmount_성공(int productPrice, int expectedAmount) {
    Credit credit = new Credit(100);

    int amount = credit.calculatePurchaseAmount(productPrice);

    assertThat(amount).isEqualTo(expectedAmount);
  }

  private static Stream<Arguments> priceAndAmount() {
    return Stream.of(
        Arguments.of(1, 100),
        Arguments.of(10, 10),
        Arguments.of(100, 1)
    );
  }

  @Test
  void calculatePurchaseAmount_실패() {
    Credit credit = new Credit(100);

    assertThrows(IllegalArgumentException.class, () -> credit.calculatePurchaseAmount(0));
  }
}
