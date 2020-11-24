package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

  @Test
  @DisplayName("티켓에 보너스 번호를 같이 보냈을 때 정상적으로 2등을 체크 하는지 테스트")
  void testScoringSecond() {
    assertThat(Rank.getRewardWithBonusBall(5, true))
        .isEqualTo(Rank.SECOND);
  }

  @Test
  @DisplayName("티켓에 보너스 번호를 같이 보냈을 때 정상적으로 3등을 체크 하는지 테스트")
  void testScoringWithBonusNumber() {
    assertThat(Rank.getRewardWithBonusBall(5, false))
        .isEqualTo(Rank.THIRD);
  }

  // TODO: true false 중복 줄일 방법 찾기
  private static Stream<Arguments> provideEnumRewardMatch() {
    return Stream.of(
        Arguments.of(0, Rank.MISS, true),
        Arguments.of(3, Rank.FIFTH, true),
        Arguments.of(4, Rank.FOURTH, true),
        Arguments.of(6, Rank.FIRST, true),
        Arguments.of(0, Rank.MISS, false),
        Arguments.of(3, Rank.FIFTH, false),
        Arguments.of(4, Rank.FOURTH, false),
        Arguments.of(6, Rank.FIRST, false)
    );
  }

  @ParameterizedTest
  @MethodSource("provideEnumRewardMatch")
  @DisplayName("5등 제외하고 나머지")
  void testOtherRanksWhenMatchedWithBonus(int numHit, Rank expected, boolean bonusBallMatched) {
    assertThat(Rank.getRewardWithBonusBall(numHit, bonusBallMatched))
        .isEqualTo(expected);
  }
}
