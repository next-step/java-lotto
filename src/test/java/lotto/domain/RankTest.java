package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.LottoMatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

  @Test
  @DisplayName("1등")
  void first() {
    assertThat(Rank.from(new LottoMatch(6, false))).isEqualTo(Rank.SIX);
  }

  @Test
  @DisplayName("2등")
  void second() {
    assertThat(Rank.from(new LottoMatch(5, true))).isEqualTo(Rank.FIVE_BONUS);
  }

  @Test
  @DisplayName("3등")
  void third() {
    assertThat(Rank.from(new LottoMatch(5, false))).isEqualTo(Rank.FIVE);
  }

  @Test
  @DisplayName("4등")
  void fourth() {
    assertThat(Rank.from(new LottoMatch(4, false))).isEqualTo(Rank.FOUR);
  }

  @Test
  @DisplayName("5등")
  void fifth() {
    assertThat(Rank.from(new LottoMatch(3, false))).isEqualTo(Rank.THREE);
  }

  @Test
  @DisplayName("등수 없음")
  void none() {
    assertThat(Rank.from(new LottoMatch(2, false))).isEqualTo(Rank.NONE);
  }
}
