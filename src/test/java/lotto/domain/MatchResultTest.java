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
        Map<Rank, Integer> winningLotteryCountMap = getMatchCountIntegerMap(three, four, five, six);
        MatchResult matchResult = MatchResult.of(winningLotteryCountMap);
        assertThat(matchResult.calculateTotalWinningAmount())
                .isEqualTo(expectWinningAmount(three, four, five, six));
    }

    private Money expectWinningAmount(int three, int four, int five, int six) {
        return Rank.FIFTH.calculateTotalWinningAmount(three)
                .add(Rank.FOURTH.calculateTotalWinningAmount(four))
                .add(Rank.THIRD.calculateTotalWinningAmount(five))
                .add(Rank.FIRST.calculateTotalWinningAmount(six));
    }

    private Map<Rank, Integer> getMatchCountIntegerMap(int three, int four, int five, int six) {
        Map<Rank, Integer> winningLotteryCountMap = new HashMap<>();
        winningLotteryCountMap.put(Rank.FIFTH, three);
        winningLotteryCountMap.put(Rank.FOURTH, four);
        winningLotteryCountMap.put(Rank.THIRD, five);
        winningLotteryCountMap.put(Rank.FIRST, six);
        return winningLotteryCountMap;
    }

}