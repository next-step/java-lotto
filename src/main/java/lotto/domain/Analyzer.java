package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Analyzer {

    private final int price;
    private final List<Integer> WIN_KEYS = Arrays.asList(3, 4, 5, 5, 6);
    private final List<Integer> BONUS_KEYS = Arrays.asList(0, 0, 0, 1, 0);

    public Analyzer(final int price) {
        this.price = price;
    }

    public final Double calculateProfitPercent(int winningMoney) {
        return winningMoney / (double) this.price;
    }

    public final int calculateTotalWinningMoney(final List<Integer> correctWinNumber,
        final List<Integer> hasBonusNumber) {

        int totalMoney = 0;
        for (int i = 0; i < WIN_KEYS.size(); i++) {
            int win = WIN_KEYS.get(i);
            int bonus = BONUS_KEYS.get(i);
            totalMoney += calculatePerStepMoney(win, bonus, correctWinNumber, hasBonusNumber);
        }
        return totalMoney;
    }

    private int calculatePerStepMoney(int win, int bonus, List<Integer> winNumbers,
        List<Integer> bonusNumbers) {
        int occurrence = countFrequency(winNumbers, win);
        if (win == 5) {
            List<Integer> filteredBonus = filter(winNumbers, bonusNumbers, win);
            occurrence = countFrequency(filteredBonus, bonus);
        }
        return WinningPrice.of(win, bonus).operate(occurrence);
    }

    private List<Integer> filter(List<Integer> source, List<Integer> target, int value) {
        List<Integer> filtered = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i) == value) {
                filtered.add(target.get(i));
            }
        }
        return filtered;
    }

    private int countFrequency(List<Integer> data, int value) {
        if (data.contains(value)) {
            return Collections.frequency(data, value);
        }
        return 0;
    }
}
