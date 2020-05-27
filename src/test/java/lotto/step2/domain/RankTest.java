package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {

  @DisplayName("주어진 파라미터에 대한 로또 랭킹을 구함")
  @ParameterizedTest
  @MethodSource("provideRankAboutSames")
  void 랭킹_확인_테스트 (int same, Rank expected) {
    assertEquals(Rank.valueOf(same), expected);
  }

  private static Stream<Arguments> provideRankAboutSames () {
    return Stream.of(
      Arguments.of(0, Rank.MISS),
      Arguments.of(1, Rank.MISS),
      Arguments.of(2, Rank.MISS),
      Arguments.of(3, Rank.FORTH),
      Arguments.of(4, Rank.THIRD),
      Arguments.of(5, Rank.SECOND),
      Arguments.of(6, Rank.FIRST)
    );
  }
}
