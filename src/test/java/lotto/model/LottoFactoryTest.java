package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoFactoryTest {

  @ParameterizedTest
  @CsvSource({
      "1000, 1",
      "800, 0",
      "0, 0",
      "1100, 1",
      "2000, 2",
      "2123, 2"
  })
  void createLottoByQuickPick(int money, int expected) {
    Lottos lottos = LottoFactory
        .createLottosByQuickPick((int) (new Money(money).getValue() / Lotto.PRICE.getValue()));

    assertThat(lottos.getLottoList().size()).isEqualTo(expected);
  }

  @Test
  void createLottoByQuickPick_0원이하입력() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      LottoFactory
          .createLottosByQuickPick((int) (new Money(-1000).getValue() / Lotto.PRICE.getValue()));
    });
  }

  @ParameterizedTest
  @MethodSource("quantityWithNumberStrArrProvider")
  void createLottoByStrArr(int quantity, String[] numberStrArr) {
    Lottos lottos = LottoFactory.createLottosByManual(numberStrArr);

    assertThat(lottos.getLottoList().size()).isEqualTo(quantity);
  }

  static Stream<Arguments> quantityWithNumberStrArrProvider() {
    return Stream.of(
        arguments(
            3,
            new String[]{
                "1, 2, 3, 4, 5, 6",
                "1, 2, 3, 4, 5, 7",
                "1, 2, 3, 4, 5, 8"
            }
        )
    );
  }
}