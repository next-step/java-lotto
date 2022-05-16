package lotto.controller;

import lotto.model.Money;
import lotto.model.Reward;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static lotto.model.Reward.*;

public class WinStatistics {
    private Map<Reward, Integer> matches;

    public WinStatistics() {
        this.matches = new HashMap(Map.of(THREE, 0, FOUR, 0, FIVE, 0, BONUS, 0, SIX, 0));
    }

    public WinStatistics(int three, int four, int five, int bonus, int six) {
        this.matches = new HashMap(Map.of(THREE, three, FOUR, four, FIVE, five, BONUS, bonus, SIX, six));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinStatistics that = (WinStatistics) o;
        return Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }

    @Override
    public String toString() {
        return "WinStatistics{" + "matches=" + matches + '}';
    }

    public void save(Reward reward) {
        matches.put(reward, matches.get(reward) + 1);
    }

    public String toPayload() {
        return Reward.toPayload(this.matches);
    }

    public int getEarnedMoney() {
        int earnedMoney = 0;
        for (Reward reward: matches.keySet()) {
            earnedMoney += reward.calculateEarnedMoney(matches.get(reward));
        }
        return earnedMoney;
    }

    public double getEarningRate(Money money) {
        return money.profitRate(this.getEarnedMoney());
    }
}
