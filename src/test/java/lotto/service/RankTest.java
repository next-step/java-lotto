package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

  @DisplayName("Rank countOfMatch 값에 따른 winningMoney을 제대로 반환하는지 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"3,5000","4,50000","5,1500000","6,2000000000"})
  void getWinningMoney(int countOfMatch, int winningMoney) {
    assertThat(Rank.matchRank(countOfMatch).getWinningMoney()).isEqualTo(winningMoney);
  }

}