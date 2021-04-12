package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankTest {

  @Test
  @DisplayName("매칭되는 당첨 번호 총 갯수와, 보너스 볼이 맞는지에 대한 여부에 의해 Rank를 반환한다.")
  void valueOf() {
    assertAll(
            () -> assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST),
            () -> assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND),
            () -> assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD),
            () -> assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH),
            () -> assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH),
            () -> assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS)
    );
  }
}