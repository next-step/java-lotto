package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @ParameterizedTest(name = "총 당첨 금액을 뽑아낼 수 있다.")
    @CsvSource(value = {"1,3,2,1", "0,0,0,0"})
    public void totalWinningPriceTest(int three, int four, int five, int six) {
        Map<MatchCount, Integer> winningLotteryCountMap = getMatchCountIntegerMap(three, four, five, six);
        MatchResult matchResult = MatchResult.of(winningLotteryCountMap);
        assertThat(matchResult.calculateTotalWinningAmount())
                .isEqualTo(expectWinningAmount(three, four, five, six));
    }

    private Money expectWinningAmount(int three, int four, int five, int six) {
        long totalAmount =  MatchCount.THREE.getWinningAmount() * three
                + MatchCount.FOUR.getWinningAmount() * four
                + MatchCount.FIVE.getWinningAmount() * five
                + MatchCount.SIX.getWinningAmount() * six;
        return Money.of(totalAmount);
    }

    private Map<MatchCount, Integer> getMatchCountIntegerMap(int three, int four, int five, int six) {
        Map<MatchCount, Integer> winningLotteryCountMap = new HashMap<>();
        winningLotteryCountMap.put(MatchCount.THREE, three);
        winningLotteryCountMap.put(MatchCount.FOUR, four);
        winningLotteryCountMap.put(MatchCount.FIVE, five);
        winningLotteryCountMap.put(MatchCount.SIX, six);
        return winningLotteryCountMap;
    }

}