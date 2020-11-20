package lotto.domain;

import lotto.domain.model.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.config.LottoGameConfig.NUMBER_COUNT_PER_GAME;
import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {
  @Test
  void 자동_게임생성_테스트() {
    Lotto newLotto = LottoGameManager.newAutoLotto();
    long validRangeCount = IntStream.range(1, 46)
        .filter(num -> newLotto.contains(new LottoNumber(num)))
        .count();

    assertThat(validRangeCount).isEqualTo(NUMBER_COUNT_PER_GAME);
  }

  @ParameterizedTest
  @MethodSource("provideManualNumbers")
  void 수동_게임생성_테스트(String[] manualNumber) {
    Lotto newLotto = LottoGameManager.newManualLotto(manualNumber);
    long validRangeCount = IntStream.range(1, 46)
        .filter(num -> newLotto.contains(new LottoNumber(num)))
        .count();

    assertThat(validRangeCount).isEqualTo(NUMBER_COUNT_PER_GAME);
  }

  static Stream<Arguments> provideManualNumbers() {
    return Stream.of(
        Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6"}),
        Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "10"})
    );
  }
}