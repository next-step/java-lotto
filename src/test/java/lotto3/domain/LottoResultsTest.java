package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

  @Test
  void 로또결과에서_상금별_개수_검증() {
    Map<Prize, Long> prizeCounts = new HashMap<>();
    prizeCounts.put(Prize.FIRST, 1L);
    prizeCounts.put(Prize.SECOND, 1L);
    prizeCounts.put(Prize.THIRD, 1L);

    LottoResults lottoResults = new LottoResults(prizeCounts);

    assertThat(lottoResults.getMatchedCount(Prize.FIRST)).isEqualTo(1);
    assertThat(lottoResults.getMatchedCount(Prize.SECOND)).isEqualTo(1);
    assertThat(lottoResults.getMatchedCount(Prize.THIRD)).isEqualTo(1);
    assertThat(lottoResults.getMatchedCount(Prize.FOURTH)).isEqualTo(0);
  }

  @Test
  void 상금5등_담청_경우_수익률_계산_검증() {
    Map<Prize, Long> prizeCounts = new HashMap<>();
    prizeCounts.put(Prize.FIFTH, 1L);

    LottoResults lottoResults = new LottoResults(prizeCounts);

    int purchaseAmount = 1000;
    double profitRate = lottoResults.calculateProfitRate(purchaseAmount);

    assertThat(profitRate).isEqualTo(5);
  }
}