package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Analyzer {

    private final List<Integer> WIN_KEYS = Arrays.asList(3, 4, 5, 5, 6);
    private final List<Integer> BONUS_KEYS = Arrays.asList(0, 0, 0, 1, 0);

    private final List<WinningPrice> winningPrices = new ArrayList<>();
    private final int price;
    private int totalWinningMoney = 0;

    public Analyzer(final int price) {
        this.price = price;
    }

    public Double calculateProfitPercent() {
        return totalWinningMoney / (double) this.price;
    }

    public void calculateTotalWinningMoney(final List<Integer> correctWinNumber,
        final List<Integer> hasBonusNumber) {

        for (int i = 0; i < WIN_KEYS.size(); i++) {
            int win = WIN_KEYS.get(i);
            int bonus = BONUS_KEYS.get(i);

            winningPrices.add(calculatePerStepMoney(win, bonus, correctWinNumber, hasBonusNumber));
        }
    }

    private WinningPrice calculatePerStepMoney(final int win, final int bonus,
        final List<Integer> winNumbers,
        List<Integer> bonusNumbers) {
        int count = countFrequency(winNumbers, win);
        if (win == 5) {
            List<Integer> filteredBonus = filter(winNumbers, bonusNumbers, win);
            count = countFrequency(filteredBonus, bonus);
        }
        WinningPrice winningPrice = WinningPrice.of(win, bonus);
        totalWinningMoney += winningPrice.operate(count);
        return winningPrice;
    }

    private List<Integer> filter(final List<Integer> source, final List<Integer> target,
        final int value) {
        List<Integer> filtered = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i) == value) {
                filtered.add(target.get(i));
            }
        }
        return filtered;
    }

    private int countFrequency(final List<Integer> data, final int value) {
        if (data.contains(value)) {
            return Collections.frequency(data, value);
        }
        return 0;
    }

    public List<WinningPrice> getWinningPrices() {
        return new ArrayList<>(winningPrices);
    }

}
