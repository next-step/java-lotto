package lotto;

import lotto.domain.game.LottoPricePerGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPricePerGameTest {

  @ParameterizedTest(name = "LottoPricePerGame | 로또 가격은 음수일 수 없다. 가격: {0}")
  @ValueSource(ints = {-1000, 0})
  void 로또_한_게임당_가격은_음수_일_수_없다 (int given) {
    // when & then
    Assertions.assertThatThrownBy(() -> new LottoPricePerGame(given))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
