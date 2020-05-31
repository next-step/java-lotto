package lotto.step4.domain;

import lotto.step4.execption.LottoLesserPriceException;
import lotto.step4.execption.LottoMinimumPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static lotto.step4.domain.LottoShop.buyLotto;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoShopTest {

  @DisplayName("구매 금액이 1000이하일 경우 LottoMinimumPriceException 발생")
  @ParameterizedTest
  @ValueSource(ints = { -1000, 0, 999 })
  void 구매_금액_검증_테스트 (long price) {
    assertThatExceptionOfType(LottoMinimumPriceException.class)
      .isThrownBy(() -> buyLotto(price, new ArrayList<>()));
  }

  @DisplayName("구매 금액에 비해 수동 입력 로또의 갯수가 많을 경우 LottoLesserPriceException 발생")
  @ParameterizedTest
  @MethodSource("providePriceAndDirectLottos")
  void 구매_금액_초과_테스트 (long price, List<Lotto> directLottos) {
    assertThatExceptionOfType(LottoLesserPriceException.class)
      .isThrownBy(() -> buyLotto(price, directLottos));
  }

  private static Stream<Arguments> providePriceAndDirectLottos () {
    List<Lotto> directLottos = Stream.of(
      LottoGenerator.generateLotto("1,2,3,4,5,6"),
      LottoGenerator.generateLotto("11,12,13,14,15,16"),
      LottoGenerator.generateLotto("21,22,23,24,25,26")
    ).collect(toList());
    return Stream.of(
      Arguments.of(1000, directLottos),
      Arguments.of(2000, directLottos)
    );
  }

  @DisplayName("로또 한 개당 1000원에 구매할 수 있는지 테스트")
  @ParameterizedTest
  @MethodSource("provideLottoCountAboutPrice")
  void 구매_갯수_테스트 (long price, long expected) {
    assertEquals(expected, buyLotto(price, new ArrayList<>()).stream().count());
  }

  private static Stream<Arguments> provideLottoCountAboutPrice () {
    return Stream.of(
      Arguments.of(10000, 10000 / 1000),
      Arguments.of(11100, 11100 / 1000),
      Arguments.of(1100, 1100 / 1000)
    );
  }

}
