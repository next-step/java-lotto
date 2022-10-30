package lotto;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FOURTH(3, 5000, 0),
    THIRD(4, 50000, 0),
    SECOND(5, 1500000, 0),
    FIRST(6, 2000000000, 0);

    private int correctCount;
    private int prize;
    private int count;

    Rank(int correctCount, int prize, int count) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.count = count;
    }

    public static Rank RankOf(int correctCount) {
        if (correctCount == 6) return Rank.FIRST;
        if (correctCount == 5) return Rank.SECOND;
        if (correctCount == 4) return Rank.THIRD;
        if (correctCount == 3) return Rank.FOURTH;
        return null;
    }

    public static List<Rank> calculate(Lotto winner, List<Lotto> myLotto) {
        for (Lotto lotto : myLotto) {
            int correctCount = winner.correctCount(lotto);
            Rank rank = RankOf(correctCount);
            if (rank == null) continue;

            RankOf(correctCount).plusCount();
        }

        return Arrays.asList(Rank.values());
    }

    public static double profit(List<Rank> ranking, double paidAmount) {
        double sum = 0.0;
        for (Rank rank : ranking) {
            sum += rank.prize * rank.count;
        }

        return sum / paidAmount;
    }

    public int getCount() {
        return count;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }

    public void plusCount() {
        count += 1;
    }
}
