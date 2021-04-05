package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RankingTest {

  @DisplayName("3~6 숫자가 아니면 DROP")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 7, 8, 9})
  void drop(int count) {
    assertThat(Ranking.find(count, false)).isEqualTo(Ranking.DROP);
    assertThat(Ranking.find(count, true)).isEqualTo(Ranking.DROP);
  }

  @DisplayName("6개 일치하면 1등")
  @Test
  void first() {
    assertThat(Ranking.find(6, true)).isEqualTo(Ranking.FIRST);
  }

  @DisplayName("5개 일치하고 보너스볼이 있으면 2등 보너스")
  @Test
  void second_bonus() {
    assertThat(Ranking.find(5, true)).isEqualTo(Ranking.SECOND_BONUS);
  }

  @DisplayName("5개 일치하고 보너스볼이 없으면 2등")
  @Test
  void second() {
    assertThat(Ranking.find(5, false)).isEqualTo(Ranking.SECOND);
  }

  @DisplayName("4개 일치하면 3등")
  @Test
  void third() {
    assertThat(Ranking.find(4, false)).isEqualTo(Ranking.THIRD);
  }

  @DisplayName("3개 일치하면 4등")
  @Test
  void fourth() {
    assertThat(Ranking.find(3, false)).isEqualTo(Ranking.FOURTH);
  }

}