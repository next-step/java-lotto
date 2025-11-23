package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

  @Test
  void findRankWithMatched() {
    assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
  }


}