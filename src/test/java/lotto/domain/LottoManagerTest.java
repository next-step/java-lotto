package lotto.domain;

import lotto.domain.model.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static lotto.config.LottoGameConfig.NUMBER_COUNT_PER_GAME;
import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {
  @Test
  void 새게임생성_테스트() {
    Lotto newLotto = LottoGameManager.newLottoGame();
    long validRangeCount = IntStream.range(1, 46)
        .filter(num -> newLotto.contains(new LottoNumber(num)))
        .count();

    assertThat(validRangeCount).isEqualTo(NUMBER_COUNT_PER_GAME);
  }
}