package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    final static int TOTAL_MATCHED_COUNT = 6;

    @Test
    @DisplayName("일치된 번호의 수와 당첨 등수 일치")
    public void aggregate() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.put(TOTAL_MATCHED_COUNT);
        assertThat(lottoResult.get(LottoLevels.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률")
    public void test() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.put(4);
        lottoResult.put(4);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(10);
    }
}
