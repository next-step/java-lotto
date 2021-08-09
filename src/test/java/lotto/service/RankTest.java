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
    assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(5);
    assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
  }

  @DisplayName("Rank에 정의된 winningMoney 확인 테스트.")
  @Test
  void getWinningMoney() {
    assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
    assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5000);
    assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(50000);
    assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(1500000);
    assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(30000000);
    assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2000000000);
  }

  @DisplayName("2등판별값과 match값을 주입하면 각 등급이 정상적으로 반환되는지 테스트.")
  @Test
  void 판별값포함등급반환테스트() {
    assertThat(Rank.matchRank(0,false)).isEqualTo(Rank.MISS);
    assertThat(Rank.matchRank(3,false)).isEqualTo(Rank.FIFTH);
    assertThat(Rank.matchRank(4,false)).isEqualTo(Rank.FOURTH);
    assertThat(Rank.matchRank(5,false)).isEqualTo(Rank.THIRD);
    assertThat(Rank.matchRank(5,true)).isEqualTo(Rank.SECOND);
    assertThat(Rank.matchRank(6,false)).isEqualTo(Rank.FIRST);
  }
}