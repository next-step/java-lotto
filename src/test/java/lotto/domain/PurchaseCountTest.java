package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseCountTest {

  @DisplayName("구매카운트 객체를 생성해서 자동구매 카운트 반환 테스트.")
  @Test
  void 구매카운트정보생성및자동구매카운트반환() {
    PurchaseCount purchaseCount = new PurchaseCount(new LottoMoney(2000),1);
    assertThat(purchaseCount.getAutoCount()).isEqualTo(1);
  }

  @DisplayName("금액 대비 초과 수량 구매 불가 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,2", "2000,3"})
  void 초과구매(int money, int count) {
    assertThatThrownBy(
        ()->new PurchaseCount(new LottoMoney(money),count)
    ).isInstanceOf(IllegalArgumentException.class);
  }
}