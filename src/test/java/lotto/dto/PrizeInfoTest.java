package lotto.dto;

import lotto.domain.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeInfoTest {

  @DisplayName("객체 생성 & 동등성 테스트")
  @Test
  void constructionAndEqualityTest() {
    LottoRanking givenLottoRanking = LottoRanking.THIRD;
    long givenWinningCount = 2;

    assertThat(new PrizeInfo(givenLottoRanking, givenWinningCount)).isEqualTo(new PrizeInfo(givenLottoRanking, givenWinningCount));
  }
}
