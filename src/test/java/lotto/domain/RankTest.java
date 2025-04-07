package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

  @DisplayName("일치 개수와 보너스 볼 여부에 따라 등수를 결정한다.")
  @ParameterizedTest
  @CsvSource({
    "6, false, FIRST",
    "5, true, SECOND",
    "5, false, THIRD",
    "4, true, FOURTH",
    "4, false, FOURTH",
    "3, true, FIFTH",
    "3, false, FIFTH",
    "2, false, MISS",
    "1, false, MISS",
    "0, false, MISS"
  })
  void valueOf(int countOfMatch, boolean matchBonus, Rank expected) {
    // when
    Rank rank = Rank.valueOf(countOfMatch, matchBonus);

    // then
    assertThat(rank).isEqualTo(expected);
  }

  @DisplayName("7개 이상의 일치 개수를 입력하면 예외가 발생한다.")
  @ParameterizedTest
  @ValueSource(ints = {7, 10, 100})
  void invalidMatchCount(int countOfMatch) {
    // when & then
    assertThatThrownBy(() -> Rank.valueOf(countOfMatch, false))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("일치하는 번호는 최대 6개까지만 가능합니다.");
  }

  @DisplayName("각 등수별 상금이 올바르게 설정되어 있다.")
  @Test
  void winningMoney() {
    // when & then
    assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
    assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(30_000_000);
    assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(1_500_000);
    assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(50_000);
    assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5_000);
    assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
  }

  @DisplayName("MISS는 0, 1, 2개 일치하는 경우를 포함한다.")
  @Test
  void missRankContainsZeroToTwo() {
    // when & then
    assertThat(Rank.MISS.getMatchCounts()).containsExactly(0, 1, 2);
  }

  @DisplayName("일치 개수에 따른 등수가 올바르게 설정되어 있다.")
  @Test
  void countOfMatch() {
    // when & then
    assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
    assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(5);
    assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(5);
    assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(4);
    assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3);
    assertThat(Rank.MISS.getCountOfMatch()).isEqualTo(2);
  }

  @DisplayName("2등만 보너스 볼이 일치해야 한다.")
  @Test
  void onlySecondMatchBonus() {
    // when & then
    assertThat(Rank.SECOND.isMatchBonus()).isTrue();
    assertThat(Rank.FIRST.isMatchBonus()).isFalse();
    assertThat(Rank.THIRD.isMatchBonus()).isFalse();
    assertThat(Rank.FOURTH.isMatchBonus()).isFalse();
    assertThat(Rank.FIFTH.isMatchBonus()).isFalse();
    assertThat(Rank.MISS.isMatchBonus()).isFalse();
  }
}
