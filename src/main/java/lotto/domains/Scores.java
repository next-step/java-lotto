package lotto.domains;

import java.util.EnumMap;
import java.util.Map;

import lotto.enums.Prize;

public class Scores {

    private Map<Prize, Integer> scores = emptyScores();

    public Scores() {
    }

    private Map<Prize, Integer> emptyScores() {
        Map<Prize, Integer> scores = new EnumMap<>(Prize.class);

        for (Prize prize : Prize.values()) {
            scores.put(prize, 0);
        }

        return scores;
    }

    public void increase(Prize key) {
        int score = this.scores.get(key) + 1;
        this.scores.put(key, score);
    }

    public long totalMoney() {
        long sum = 0;

        for (Prize prize : this.scores.keySet()) {
            long money = (long)prize.getPrize() * (long)scores.get(prize);
            sum += money;
        }

        return sum;
    }

    public int of(Prize prize) {
        return this.scores.get(prize);
    }

    public boolean equals(Scores other) {
        return this.scores.equals(other.scores);
    }

}
