package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

  @DisplayName("Rank countOfMatch 값을 제대로 반환하는지 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"3,3","4,4","5,5","6,6"})
  void getCountOfMatch(int countOfMatch, int result) {
    assertThat(Rank.matchRank(countOfMatch).getCountOfMatch()).isEqualTo(result);
  }

  @DisplayName("Rank에 정의된 countOfMatch 확인 테스트.")
  @Test
  void getCountOfMatch() {
    assertThat(Rank.MISS.getCountOfMatch()).isEqualTo(0);
    assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3);
    assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(4);
    assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(5);
    assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
  }

  @DisplayName("Rank에 정의된 winningMoney 확인 테스트.")
  @Test
  void getWinningMoney() {
    assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
    assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5000);
    assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(50000);
    assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(1500000);
    assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2000000000);
  }

}