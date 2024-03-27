package lottoTest;

import static lotto.LottoRank.FIFTH;
import static lotto.LottoRank.FOURTH;
import static lotto.LottoRank.LOSE;
import static lotto.LottoRank.THIRD;
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
        LottoResult lottoResult = new LottoResult(FOURTH, THIRD, FIFTH, LOSE);

        assertThat(lottoResult.calculateReturnRate(22000)).isEqualTo(70.68);
    }

}
