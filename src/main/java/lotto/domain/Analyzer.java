package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Analyzer {

    private static final Map<Integer, Integer> POSSIBLE_LOTTO_WINNING_MONEY = createPossibleLottoWinningMoneyKey();

    private final List<WinningPrice> winningPrices = new ArrayList<>();
    private final int price;

    private int totalWinningMoney = 0;

    public Analyzer(final Price price) {
        this.price = price.getPrice();
    }

    private static Map<Integer, Integer> createPossibleLottoWinningMoneyKey() {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
        result.put(5, 1);
        result.put(6, 0);
        return result;
    }

    public Double calculateProfitPercent() {
        return totalWinningMoney / (double) this.price;
    }

    public void calculateTotalWinningMoney(final List<WinningResult> winningResult) {
        for (Entry<Integer, Integer> integerBooleanEntry : POSSIBLE_LOTTO_WINNING_MONEY.entrySet()) {
            final int win = integerBooleanEntry.getKey();
            final int bonus = integerBooleanEntry.getValue();
            winningPrices.add(calculatePerStepMoney(win, bonus, winningResult));
        }
    }

    public List<WinningPrice> getWinningPrices() {
        return new ArrayList<>(winningPrices);
    }

    private WinningPrice calculatePerStepMoney(final int win, final int bonus,
        final List<WinningResult> winningResults) {
        int count = correctCountFrequency(winningResults, win);
        if (win == 5) {
            count = bonusCountFrequency(winningResults, bonus);
        }
        WinningPrice winningPrice = WinningPrice.of(win, bonus);
        totalWinningMoney += winningPrice.operate(count);
        return winningPrice;
    }

    private int correctCountFrequency(final List<WinningResult> winningResults, final int value) {
        int count = 0;
        for (WinningResult winningResult : winningResults) {
            if (winningResult.getMatchCount() == value) {
                count++;
            }
        }
        return count;
    }

    private int bonusCountFrequency(final List<WinningResult> winningResults, final int value) {
        int count = 0;
        for (WinningResult winningResult : winningResults) {
            if (winningResult.getMatchCount() == 5 && winningResult.getHasBonus() == value) {
                count++;
            }
        }
        return count;
    }
}
