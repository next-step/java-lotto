package lottoTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lotto.LottoRank;
import lotto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    @DisplayName("당첨 결과 수익률 계산 테스트")
    void CALCULATE_RATE_OF_RETURN_TEST() {
        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.FOURTH, 1);
        LottoResult lottoResult = new LottoResult(result);

        assertThat(lottoResult.calculateReturnRate(14000)).isEqualTo(0.35);
    }

}
