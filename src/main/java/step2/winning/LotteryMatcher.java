package step2.winning;

import step2.lottery.Lotterys;

import java.util.EnumMap;
import java.util.Map;

public class LotteryMatcher {
    public static WinningResults match(PrizeWinningNumber prize, Lotterys lotterys) {
        Map<Winning, Integer> prizeAmounts = initializePrizeAmounts();
        for (int i = 0; i < lotterys.length(); i++) {
            int matchCount = lotterys.getLottery(i).match(prize.getPrizeWinningNumbers());
            boolean bonus = (matchCount == 5 && lotterys.getLottery(i).contains(prize.getBonusNumber()));
            Winning winning = Winning.valueOf(matchCount, bonus);
            prizeAmounts.put(winning, prizeAmounts.get(winning) + 1);
        }
        return new WinningResults(prizeAmounts);
    }

    private static Map<Winning, Integer> initializePrizeAmounts() {
        Map<Winning, Integer> prizeAmounts = new EnumMap<>(Winning.class);
        for (Winning winning : Winning.values()) {
            prizeAmounts.put(winning, 0);
        }
        return prizeAmounts;
    }
}
