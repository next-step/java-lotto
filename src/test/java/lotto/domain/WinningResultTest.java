package lotto.domain;

import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(winningResult.getRateOfReturn(new LottoBuyDetails(1000))).isEqualTo(BigDecimal.ZERO);
    }


    @Test
    void getRateOfReturn_1등() {
        Map<LottoRankEnum, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoRankEnum.FIRST, 1);
        WinningResult winningResult = new WinningResult(resultMap);
        LottoBuyDetails lottoBuyDetails = new LottoBuyDetails(1000);
        Assertions.assertThat(winningResult.getRateOfReturn(lottoBuyDetails)).isEqualTo(LottoRankEnum.FIRST.getWinningAmount().divide(lottoBuyDetails.getTotalPaymentAmount(), 2, RoundingMode.DOWN));
    }


}
