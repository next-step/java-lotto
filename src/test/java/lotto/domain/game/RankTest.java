package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class RankTest {

  @ParameterizedTest
  @EnumSource(Rank.class)
  void checkRankType(Rank rank) {
    assertThat(rank).isNotNull();
  }

  @Test
  void checkInvalidRank() {
    assertThatThrownBy(() -> Rank.valueOf("INVALID"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource({
      "5, true, SECOND",
      "5, false, THIRD"
  })
  void findSecondAndThirdBasedOnBonusMatched(int matched, boolean bonusMatched, Rank rank) {
    assertThat(Rank.valueOf(matched, bonusMatched)).isEqualTo(rank);
  }

  @ParameterizedTest
  @CsvSource({"6, false, FIRST", "6, true, FIRST", "4, true, FOURTH", "4, false, FOURTH"})
  void otherRank(int matched, boolean bonusMatched, Rank rank) {
    assertThat(Rank.valueOf(matched, bonusMatched)).isEqualTo(rank);
  }

}