package lotto.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {
  private static final List<Lotto> AUTO_LOTTOS = Stream.of(
    LottoGenerator.generateLotto("1,2,3,4,5,6"),
    LottoGenerator.generateLotto("11,12,13,14,15,16"),
    LottoGenerator.generateLotto("21,22,23,24,25,26")
  ).collect(toList());
  private static final List<Lotto> DIRECT_LOTTOS = Stream.of(
    LottoGenerator.generateLotto("9,8,7,6,5,4"),
    LottoGenerator.generateLotto("19,18,17,16,15,14"),
    LottoGenerator.generateLotto("29,28,27,26,25,24")
  ).collect(toList());

  @DisplayName("자동 로또의 갯수를 검증")
  @ParameterizedTest
  @MethodSource("provideLottosAndExpected1")
  void 자동_로또_갯수_테스트 (Lottos lottos, long expected) {
    assertEquals(lottos.getAutoLottosSize(), expected);
  }

  private static Stream<Arguments> provideLottosAndExpected1 () {
    List<Lotto> autoLottos1 = AUTO_LOTTOS.stream().limit(1L).collect(toList());
    List<Lotto> autoLottos2 = AUTO_LOTTOS.stream().limit(2L).collect(toList());
    return Stream.of(
      Arguments.of(Lottos.of(DIRECT_LOTTOS, autoLottos1), 1),
      Arguments.of(Lottos.of(DIRECT_LOTTOS, autoLottos2), 2)
    );
  }

  @DisplayName("수동 로또의 갯수를 검증")
  @ParameterizedTest
  @MethodSource("provideLottosAndExpected2")
  void 수동_로또_갯수_테스트 (Lottos lottos, long expected) {
    assertEquals(lottos.getDirectLottosSize(), expected);
  }

  private static Stream<Arguments> provideLottosAndExpected2 () {
    List<Lotto> directLottos1 = DIRECT_LOTTOS.stream().limit(1L).collect(toList());
    List<Lotto> directLottos2 = DIRECT_LOTTOS.stream().limit(2L).collect(toList());
    return Stream.of(
      Arguments.of(Lottos.of(directLottos1, AUTO_LOTTOS), 1),
      Arguments.of(Lottos.of(directLottos2, AUTO_LOTTOS), 2)
    );
  }

  @DisplayName("전체 로또의 갯수를 검증")
  @Test
  void 전체_로또_갯수_테스트 () {
    assertEquals(Lottos.of(DIRECT_LOTTOS, AUTO_LOTTOS).stream().count(), 6);
  }

}
