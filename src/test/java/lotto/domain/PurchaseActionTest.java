package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseActionTest {

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "2000:2", "3000:3"}, delimiter = ':')
  void 객체_생성_테스트(int price, int count) {
    assertThat(new PurchaseAction(price)).isEqualTo(new PurchaseAction(price, count));
  }

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "2000:2", "3000:3"}, delimiter = ':')
  void 새로만들어진_게임_횟수_테스트(int price, int count) {
    assertThat(new PurchaseAction(price).purchase().getGameSize()).isEqualTo(count);
  }
}