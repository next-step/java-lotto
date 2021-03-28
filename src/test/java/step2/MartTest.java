package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Cash;
import step2.service.Mart;

public class MartTest {
  @ParameterizedTest
  @CsvSource(value = {"1000:1", "14000:14", "28000:28"}, delimiter = ':')
  @DisplayName("유효한 가격으로 구매 가능한지 테스트")
  void validBuyLottoTest(int sellerMoney, int size) {
    Assertions.assertThat(Mart.buyAllLotto(new Cash(sellerMoney)).quantity()).isEqualTo(size);
  }

  @ParameterizedTest
  @ValueSource(ints = {900, 999})
  @DisplayName("유효하지 않은 금액으로 로또 구매 불가한지 테스트")
  void invalidMoneyTest(int sellerMoney) {
    Assertions.assertThatThrownBy(() -> Mart.buyAllLotto(new Cash(sellerMoney))).isInstanceOf(RuntimeException.class).hasMessage("로또를 살 수 없습니다.");
  }
}
