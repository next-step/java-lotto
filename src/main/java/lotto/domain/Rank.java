package lotto.domain;

public enum Rank {
    THREE("3개 일치 (5000원)- ", 5000, 3),
    FOUR("4개 일치 (50000원)- ", 50000, 4),
    FIVE("5개 일치 (1500000원)- ", 1500000, 5),
    WIN("6개 일치 (2000000000원)- ", 2000000000, 6);

    private final String message;
    private final int prize;
    private final int matchNumber;

    Rank(String message, int prize, int matchNumber) {
        this.message = message;
        this.prize = prize;
        this.matchNumber = matchNumber;
    }

    public static long calculatePrize(int count, Rank rank) {
        return (long)count * rank.prize;
    }

    public static double ratio(long totalPrize, int money) {
        double ratio = (double)totalPrize / money;

        return Math.floor(ratio * 100) / 100.0;
    }

    public boolean isMatch(int matchCount) {
        if (matchCount == this.matchNumber) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        return message;
    }
}
