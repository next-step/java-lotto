package step3.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

  @Test
  void findRankByCountOfMatch() {
  }

  @ParameterizedTest
  @DisplayName("5등 확인 테스트")
  @CsvSource(value = "3,false")
  void fifthPlaceTest(int countOfMatch, boolean bonusFlag) {
    assertThat(Rank.findRankByCountOfMatch(countOfMatch, bonusFlag)).isEqualTo(Rank.FIFTH);
  }

  @ParameterizedTest
  @DisplayName("4등 확인 테스트")
  @CsvSource(value = "4,true")
  void fourthPlaceTest(int countOfMatch, boolean bonusFlag) {
    assertThat(Rank.findRankByCountOfMatch(countOfMatch, bonusFlag)).isEqualTo(Rank.FOURTH);
  }

  @ParameterizedTest
  @DisplayName("3등 확인 테스트")
  @CsvSource(value = "5,false")
  void thirdPlaceTest(int countOfMatch, boolean bonusFlag) {
    assertThat(Rank.findRankByCountOfMatch(countOfMatch, bonusFlag)).isEqualTo(Rank.THIRD);
  }

  @ParameterizedTest
  @DisplayName("2등 확인 테스트")
  @CsvSource(value = "5,true")
  void secondPlaceTest(int countOfMatch, boolean bonusFlag) {
    assertThat(Rank.findRankByCountOfMatch(countOfMatch, bonusFlag)).isEqualTo(Rank.SECOND);
  }

  @ParameterizedTest
  @DisplayName("1등 확인 테스트")
  @CsvSource(value = "6,false")
  void firstPlaceTest(int countOfMatch, boolean bonusFlag) {
    assertThat(Rank.findRankByCountOfMatch(countOfMatch, bonusFlag)).isEqualTo(Rank.FIRST);
  }
}