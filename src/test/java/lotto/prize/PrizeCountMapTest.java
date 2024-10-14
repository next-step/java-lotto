package lotto.prize;

import lotto.number.LottoBalls;
import lotto.number.LottoNumber;
import lotto.number.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeCountMapTest {

    @DisplayName("로또의 수익률을 계산할 수 있다.")
    @Test
    void calculateProfitRate() {
        LottoBalls winningNumber = new LottoBalls(List.of(1, 2, 3, 33, 34, 35));
        LottoNumber bonusNumber = new LottoNumber(4);

        List<LottoBalls> lottoBalls = new ArrayList<>();
        lottoBalls.add(new LottoBalls(List.of(1, 2, 3, 4, 5, 6)));
        lottoBalls.add(new LottoBalls(List.of(1, 2, 3, 4, 5, 6)));
        lottoBalls.add(new LottoBalls(List.of(1, 2, 3, 4, 5, 6)));
        lottoBalls.add(new LottoBalls(List.of(1, 2, 3, 4, 5, 6)));

        PrizeCounter prizeCounter = new PrizeCounter(lottoBalls, new WinningNumbers(winningNumber, bonusNumber));
        PrizeCountMap prizeCountMap = prizeCounter.countPrize();

        double result = prizeCountMap.calculateProfitRate(lottoBalls.size());

        assertThat(result).isEqualTo(5.0);

    }
}
