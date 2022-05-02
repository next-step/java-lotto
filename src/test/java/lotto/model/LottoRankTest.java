package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

  @ParameterizedTest(name = "우승 로또번호와 일치하는 갯수가 {0}일때 로또 랭킹은 {1}이다")
  @CsvSource({"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "2,NON_MATCH", "1,NON_MATCH",
      "0,NON_MATCH"})
  void findNumberOfMatchesWithWinningLottoNumbers(int numberOfMatch, LottoRank lottoRank) {
    // when
    LottoRank findLottoRank = LottoRank.findRank(numberOfMatch);

    // then
    assertThat(findLottoRank).isEqualTo(lottoRank);
  }

  @ParameterizedTest(name = "{0}의 경우 일치하는 갯수는 {1}임을 의미한다")
  @CsvSource({"FIRST,6", "SECOND,5", "THIRD,4", "FOURTH,3", "NON_MATCH,0"})
  void checkReturnTheNumberOfMatches(LottoRank lottoRank, int expected) {
    // when
    int numberOfMatch = lottoRank.getNumberOfMatch();

    // then
    assertThat(numberOfMatch).isEqualTo(expected);
  }

  @ParameterizedTest(name = "로또 당첨 랭킹이 {0}이면 우승상금은 {1}이다")
  @CsvSource({"FIRST,2000000000", "SECOND,1500000", "THIRD,50000", "FOURTH,5000", "NON_MATCH,0"})
  void checkWinningPrizeAccordingToTheLottoRanking(LottoRank lottoRank, int expected) {
    // when
    int reward = lottoRank.getReward();

    // then
    assertThat(reward).isEqualTo(expected);
  }
}
