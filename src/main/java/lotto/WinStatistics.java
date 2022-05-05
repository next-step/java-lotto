package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinStatistics {
    private Map<Integer, Integer> matches;

    public WinStatistics() {
        this.matches = new HashMap(Map.of(3, 0, 4, 0, 5, 0, 6, 0));
    }

    public WinStatistics(int three, int four, int five, int six) {
        this.matches = new HashMap(Map.of(3, three, 4, four, 5, five, 6, six));
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

    public void save(int wins) {
        matches.put(wins, matches.get(wins) + 1);
    }

    public String toPayload() {
        StringBuilder payload = new StringBuilder("");
        for (int key : matches.keySet()) {
            payload.append(key + " matches (₩" + Reward.of(key).value + "): " + matches.get(key) + "\n");
        }
        return payload.toString();
    }

    public int getEarnedMoney() {
        int earnedMoney = 0;
        for (int key : matches.keySet()) {
            earnedMoney += Reward.of(key).value * matches.get(key);
        }
        return earnedMoney;
    }


    public String didEarn(Money money) {
        return money.didEarn(this.getEarnedMoney());
    }

    public double getEarningRate(Money money) {
        return money.getEarningRate(this.getEarnedMoney());
    }
}
