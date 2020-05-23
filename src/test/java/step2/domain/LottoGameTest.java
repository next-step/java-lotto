package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.LottoGamePriceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoGameTest {

  @DisplayName("구매 금액이 1000이하일 경우 LottoGamePriceException 발")
  @ParameterizedTest
  @ValueSource(ints = { -1000, 0, 999 })
  void 구매_금액_검증_테스트 (int price) {
    assertThatExceptionOfType(LottoGamePriceException.class)
      .isThrownBy(() -> LottoGame.of(price));
  }
}
