package step1.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.Rank;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
  @DisplayName("랭크의 일치 여부를 가져오는 테스트")
  @ParameterizedTest
  @MethodSource("provideEqualRank")
  void 랭크_테스트 (int same, boolean matchBonus, Rank expected) {
    assertThat(expected).isEqualTo(Rank.valueOf(same, matchBonus));
  }

  private static Stream<Arguments> provideEqualRank () {
    return Stream.of(
      Arguments.of(1, true, Rank.MISS),
      Arguments.of(1, false, Rank.MISS),
      Arguments.of(2, true, Rank.MISS),
      Arguments.of(2, false, Rank.MISS),
      Arguments.of(3, true, Rank.FIFTH),
      Arguments.of(3, false, Rank.FIFTH),
      Arguments.of(4, true, Rank.FORTH),
      Arguments.of(4, false, Rank.FORTH),
      Arguments.of(5, true, Rank.SECOND),
      Arguments.of(5, false, Rank.THIRD),
      Arguments.of(6, true, Rank.FIRST),
      Arguments.of(6, false, Rank.FIRST)
    );
  }
}
