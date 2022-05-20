package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

  @Test
  @DisplayName("로또 1등")
  void givenMatchCount_ShouldBeTopRank() {
    assertThat(Rank.of(6, true)).isEqualTo(Rank.TOP);
    assertThat(Rank.of(6, false)).isEqualTo(Rank.TOP);
  }

  @Test
  @DisplayName("로또 2등")
  void givenMatchCount_ShouldBeTopSecond() {
    assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
  }

  @Test
  @DisplayName("로또 3등")
  void givenMatchCount_ShouldBeTopThird() {
    assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
  }

  @Test
  @DisplayName("로또 4등")
  void givenMatchCount_ShouldBeTopFourth() {
    assertThat(Rank.of(4, true)).isEqualTo(Rank.FOURTH);
  }

  @Test
  @DisplayName("로또 5등")
  void givenMatchCount_ShouldBeTopFifth() {
    assertThat(Rank.of(3, true)).isEqualTo(Rank.FIFTH);
  }

  @Test
  @DisplayName("로또 꽝")
  void givenMatchCount_ShouldBeTopNone() {
    assertThat(Rank.of(2, true)).isEqualTo(Rank.NONE);
    assertThat(Rank.of(1, true)).isEqualTo(Rank.NONE);
    assertThat(Rank.of(0, true)).isEqualTo(Rank.NONE);
  }
}