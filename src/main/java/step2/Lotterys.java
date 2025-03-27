package step2;

import step2.shuffle.Shuffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotterys {
    private List<Lottery> lottos;
    private final int LOTTO_LENGTH = 6;
    public Lotterys(int count, Shuffle shuffle) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lottery(shuffle.makeRandomNumbers(LOTTO_LENGTH)));
        }
    }

    public int length() {
        return lottos.size();
    }

    public Lottery getLotto(int index) {
        return lottos.get(index);
    }

    public WinningResults prizeWinning(String input) {
        Map<Winning, Integer> prizeAmounts = initializePrizeAmounts();
        PrizeWinningNumber prizeWinningNumber = new PrizeWinningNumber(input);

        for (Lottery lotto : lottos) {
            int matchCount = lotto.match(prizeWinningNumber.getPrizeWinningNumbers());
            prizeAmounts.put(Winning.valueOf(matchCount), prizeAmounts.get(Winning.valueOf(matchCount)) + 1);
        }
        return new WinningResults(prizeAmounts);
    }

    private Map<Winning, Integer> initializePrizeAmounts() {
        Map<Winning, Integer> prizeAmounts = new HashMap<>();
        for (Winning winning : Winning.values()) {
            prizeAmounts.put(winning, 0);
        }
        return prizeAmounts;
    }
}
