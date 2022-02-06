package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Analyzer {

    private final List<Integer> WIN_KEYS = Arrays.asList(3, 4, 5, 5, 6);
    private final List<Integer> BONUS_KEYS = Arrays.asList(0, 0, 0, 1, 0);

    private final List<Ranking> rankings = new ArrayList<>();
    private final int payment;
    private double prizeMoney = 0;

    public Analyzer(final int payment) {
        this.payment = payment;
    }

    public Double calculateProfitPercent() {
        return prizeMoney / this.payment;
    }

    public void calculateTotalPrizeMoney(final List<Integer> correctWinNumber,
        final List<Integer> hasBonusNumber) {

        for (int i = 0; i < WIN_KEYS.size(); i++) {
            int win = WIN_KEYS.get(i);
            int bonus = BONUS_KEYS.get(i);

            rankings.add(calculatePerStepMoney(win, bonus, correctWinNumber, hasBonusNumber));
        }
    }

    private Ranking calculatePerStepMoney(int win, int bonus, List<Integer> winNumbers,
        List<Integer> bonusNumbers) {
        int count = countFrequency(winNumbers, win);
        if (win == 5) {
            List<Integer> filteredBonus = filter(winNumbers, bonusNumbers, win);
            count = countFrequency(filteredBonus, bonus);
        }
        Ranking ranking = Ranking.of(win, bonus);
        prizeMoney += ranking.operate(count);
        return ranking;
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

    public List<Ranking> getRankings() {
        return new ArrayList<>(rankings);
    }
}
