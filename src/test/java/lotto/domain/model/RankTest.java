package lotto.domain.model;

import static lotto.domain.model.Rank.FAILURE;
import static lotto.domain.model.Rank.FIFTH;
import static lotto.domain.model.Rank.FIRST;
import static lotto.domain.model.Rank.FOURTH;
import static lotto.domain.model.Rank.SECOND;
import static lotto.domain.model.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RankTest {

  @DisplayName("Test for Calculating the rank according to match results")
  @Test
  public void calculateRankTest() {
    assertThat(Rank.valueOf(0, false)).isEqualTo(FAILURE);
    assertThat(Rank.valueOf(0, true)).isEqualTo(FAILURE);
    assertThat(Rank.valueOf(1, false)).isEqualTo(FAILURE);
    assertThat(Rank.valueOf(1, true)).isEqualTo(FAILURE);
    assertThat(Rank.valueOf(2, false)).isEqualTo(FAILURE);
    assertThat(Rank.valueOf(2, true)).isEqualTo(FAILURE);

    assertThat(Rank.valueOf(3, false)).isEqualTo(FIFTH);
    assertThat(Rank.valueOf(3, true)).isEqualTo(FIFTH);

    assertThat(Rank.valueOf(4, false)).isEqualTo(FOURTH);
    assertThat(Rank.valueOf(4, true)).isEqualTo(FOURTH);

    assertThat(Rank.valueOf(5, false)).isEqualTo(THIRD);

    assertThat(Rank.valueOf(5, true)).isEqualTo(SECOND);

    assertThat(Rank.valueOf(6, false)).isEqualTo(FIRST);
  }

  @DisplayName("Test for illegal argument")
  @ParameterizedTest
  @ValueSource(ints = {-1, 7})
  public void illegalArgumentTest(int matchCount) {
    assertThatThrownBy(() -> Rank.valueOf(matchCount, true))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
