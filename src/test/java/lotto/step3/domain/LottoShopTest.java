package lotto.step3.domain;

import lotto.step2.exception.LottoGamePriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static lotto.step2.domain.LottoShop.buyLotto;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoShopTest {

  @DisplayName("구매 금액이 1000이하일 경우 LottoGamePriceException 발생")
  @ParameterizedTest
  @ValueSource(ints = { -1000, 0, 999 })
  void 구매_금액_검증_테스트 (int price) {
    assertThatExceptionOfType(LottoGamePriceException.class)
      .isThrownBy(() -> buyLotto(price));
  }

  @DisplayName("로또 한 개당 1000원에 구매할 수 있는지 테스트")
  @ParameterizedTest
  @MethodSource("provideLottoCountAboutPrice")
  void 구매_갯수_테스트 (long price, long expected) {
    assertEquals(expected, buyLotto(price).stream().count());
  }

  private static Stream<Arguments> provideLottoCountAboutPrice () {
    return Stream.of(
      Arguments.of(10000, 10000 / 1000),
      Arguments.of(11100, 11100 / 1000),
      Arguments.of(1100, 1100 / 1000)
    );
  }

}
