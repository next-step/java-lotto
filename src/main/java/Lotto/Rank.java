package lotto;

public enum Rank {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int correctCount;
    private int prize;

    Rank(int correctCount, int prize) {
        this.correctCount = correctCount;
        this.prize = prize;
    }

    public static Rank RankOf(int correctCount) {
        if (correctCount == 6) return Rank.FIRST;
        if (correctCount == 5) return Rank.SECOND;
        if (correctCount == 4) return Rank.THIRD;
        if (correctCount == 3) return Rank.FOURTH;
        return Rank.NONE;
    }

    public static Rank getRank(Lotto winner, Lotto myLotto) {
        return RankOf(winner.correctCount(myLotto));
    }

    public boolean isNotNone() {
        return this != NONE;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }
}
