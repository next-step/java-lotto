package lotto.domain;

import static lotto.config.LottoGameConfig.NUMBER_COUNT_PER_GAME;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import lotto.domain.model.LottoNumber;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

  @Test
  void 자동_게임생성_테스트() {
    Lotto newLotto = LottoGameManager.newAutoLotto();
    long validRangeCount = IntStream.range(1, 46)
        .filter(num -> newLotto.contains(new LottoNumber(num)))
        .count();

    assertThat(validRangeCount).isEqualTo(NUMBER_COUNT_PER_GAME);
  }
}