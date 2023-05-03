package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryCalculator {
    private static final List<Integer> REWARD_AMOUNT_FOR_NUM_MATCHES = List.of(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    public Integer getNumMatches(Lottery lottery, Set<Integer> numbers) {
        var lotteryNumbers = new HashSet<>(lottery.getNumbers());
        lotteryNumbers.retainAll(numbers);
        return lotteryNumbers.size();
    }

    public List<Integer> getLotteryCountForNumMatches(List<Lottery> lotteries, Set<Integer> numbers) {
        var lotteryCountForNumMatches = new ArrayList<>(Collections.nCopies(numbers.size() + 1, 0));
        for (var lottery : lotteries) {
            final var numMatches = getNumMatches(lottery, numbers);
            final var currentLotteryCountForNumMatches = lotteryCountForNumMatches.get(numMatches);
            lotteryCountForNumMatches.set(numMatches, currentLotteryCountForNumMatches + 1);
        }
        return lotteryCountForNumMatches;
    }

    public PnLResult getPnLResultFromLotteryCountForNumMatches(List<Integer> lotteryCountForNumMatches, Integer totalInvestment) {
        var profit = 0;
        for (var i = 0; i < 6; i++) {
            profit += lotteryCountForNumMatches.get(i) * REWARD_AMOUNT_FOR_NUM_MATCHES.get(i);
        }
        var pnLResult = new PnLResult();
        pnLResult.ror = profit / (float)totalInvestment;
        pnLResult.pnLType = PnLType.fromProfitAndTotalInvestment(profit, totalInvestment);
        return pnLResult;
    }
}
