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
    assertThat(Ranking.ofCount(count)).isEqualTo(Ranking.DROP);
  }

}