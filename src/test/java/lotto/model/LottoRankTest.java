package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

  @ParameterizedTest
  @DisplayName("우승 로또번호와 일치하는 갯수가 {0}일때 로또 랭킹은 {1}이다")
  @CsvSource({"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "2,NON_MATCH", "1,NON_MATCH", "0,NON_MATCH"})
  void findNumberOfMatchesWithWinningLottoNumbers(int numberOfMatch, LottoRank lottoRank) {
    // when
    LottoRank findLottoRank = LottoRank.findRank(numberOfMatch);

    // then
    assertThat(findLottoRank).isEqualTo(lottoRank);
  }
}