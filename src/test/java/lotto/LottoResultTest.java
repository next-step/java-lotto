package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

import static lotto.domain.LottoRank.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("수익률은 소수점 2자리 실수로 표현되어야 한다.")
    public void earningsRateTest() {
        Money input = Money.won(14000);
        Map<LottoRank, LottoTicket> lottoResult = new EnumMap<>(LottoRank.class);
        lottoResult.put(FIRST, LottoTicket.with(LottoNumbers.valueOf(1,2,3,4,5,6)));
        LottoResults results = new LottoResults(lottoResult);

        BigDecimal earningRate = results.calculateEarningRate(input, 2, RoundingMode.FLOOR);

        assertThat(earningRate).isEqualTo(BigDecimal.valueOf(142857.14));
    }

}
