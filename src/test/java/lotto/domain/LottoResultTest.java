package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

  @DisplayName("당첨 결과를 추가하면 해당 결과의 개수가 증가한다.")
  @Test
  void add() {
    // given
    LottoResult lottoResult = new LottoResult();

    // when
    lottoResult.addRank(Rank.FOURTH);
    lottoResult.addRank(Rank.FOURTH);
    lottoResult.addRank(Rank.THIRD);

    // then
    assertThat(lottoResult.getRankCount(Rank.FOURTH)).isEqualTo(2);
    assertThat(lottoResult.getRankCount(Rank.THIRD)).isEqualTo(1);
  }

  @DisplayName("일치하는 번호가 3개 미만이면 MISS 등수로 처리된다.")
  @Test
  void addLessThanThree() {
    // given
    LottoResult lottoResult = new LottoResult();

    // when
    lottoResult.addRank(Rank.MISS);
    lottoResult.addRank(Rank.MISS);

    // then
    assertThat(lottoResult.getRankCount(Rank.MISS)).isEqualTo(2);
  }

  @DisplayName("당첨금을 계산한다.")
  @Test
  void calculateTotalPrize() {
    // given
    LottoResult lottoResult = new LottoResult();
    lottoResult.addRank(Rank.FOURTH);
    lottoResult.addRank(Rank.THIRD);
    lottoResult.addRank(Rank.SECOND);
    lottoResult.addRank(Rank.FIRST);

    // when
    long totalPrize = lottoResult.calculateTotalPrize();

    // then
    long expected = 50_000 + 1_500_000 + 30_000_000 + 2_000_000_000;
    assertThat(totalPrize).isEqualTo(expected);
  }

  @DisplayName("수익률을 계산한다.")
  @Test
  void calculateProfitRate() {
    // given
    LottoResult lottoResult = new LottoResult();
    lottoResult.addRank(Rank.FIFTH); // 5,000원

    // when
    double profitRate = lottoResult.calculateProfitRate(1000);

    // then
    assertThat(profitRate).isEqualTo(5.0);
  }

  @DisplayName("등수별 당첨 횟수를 확인한다.")
  @Test
  void getRankCounts() {
    // given
    LottoResult lottoResult = new LottoResult();
    lottoResult.addRank(Rank.FIFTH);
    lottoResult.addRank(Rank.FIFTH);
    lottoResult.addRank(Rank.FOURTH);
    lottoResult.addRank(Rank.SECOND);

    // when
    int fifthCount = lottoResult.getRankCount(Rank.FIFTH);
    int fourthCount = lottoResult.getRankCount(Rank.FOURTH);
    int secondCount = lottoResult.getRankCount(Rank.SECOND);
    int firstCount = lottoResult.getRankCount(Rank.FIRST);

    // then
    assertThat(fifthCount).isEqualTo(2);
    assertThat(fourthCount).isEqualTo(1);
    assertThat(secondCount).isEqualTo(1);
    assertThat(firstCount).isEqualTo(0);
  }
}
