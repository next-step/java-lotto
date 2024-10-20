package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class WinningResultTest {
    @Test
    void getRank() {
        WinningResult winningResult = new WinningResult();
        Assertions.assertThat(winningResult.getRankCount(LottoRankEnum.FIRST)).isEqualTo(0);
    }

    @Test
    void addResult() {
        WinningResult winningResult = new WinningResult();
        winningResult.addResult(LottoRankEnum.FIRST);
        Assertions.assertThat(winningResult.getRankCount(LottoRankEnum.FIRST)).isEqualTo(1);
    }

    @Test
    void getRateOfReturn() {
        WinningResult winningResult = new WinningResult();
        Assertions.assertThat(winningResult.getRateOfReturn(1)).isEqualTo(BigDecimal.ZERO);
    }


    @Test
    void getRateOfReturn_1등() {
        Map<LottoRankEnum, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoRankEnum.FIRST, 1);
        WinningResult winningResult = new WinningResult(resultMap);
        Assertions.assertThat(winningResult.getRateOfReturn(1)).isEqualTo(LottoRankEnum.FIRST.getWinningAmount().divide(LottoUnitAmount.getBigDecimalVal(), 2, RoundingMode.DOWN));
    }


}
