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
  void 천원으로_로또_구매해서_상금_5000원인_5등에_당첨되다면_수익율_계산_검증() {
    Map<Prize, Long> prizeCounts = new HashMap<>();
    prizeCounts.put(Prize.FIFTH, 1L);

    LottoResults lottoResults = new LottoResults(prizeCounts);

    double actualProfitRate = 5;
    Money investMoney = new Money(1000);
    double expectedProfitRate = lottoResults.calculateProfitRate(investMoney);

    assertThat(expectedProfitRate).isEqualTo(actualProfitRate);
  }

  @Test
  void 로또결과에서_1등당첨_없는_경우_결과_0개반환() {
    Map<Prize, Long> prizeCounts = new HashMap<>();
    prizeCounts.put(Prize.SECOND, 1L);
    prizeCounts.put(Prize.THIRD, 1L);

    LottoResults lottoResults = new LottoResults(prizeCounts);

    assertThat(lottoResults.getMatchedCount(Prize.FIRST)).isEqualTo(0);
  }
}