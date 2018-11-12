package game.lotto.model;

public enum Rank {
    MISS(0, 0, MessageFormat.COMMON),
    FIFTH(3, 5_000, MessageFormat.COMMON),
    FOURTH(4, 50_000, MessageFormat.COMMON),
    THIRD(5, 1_500_000, MessageFormat.COMMON),
    SECOND(5, 30_000_000, MessageFormat.BONUS),
    FIRST(6, 2_000_000_000, MessageFormat.COMMON);

    private int countOfMatch;
    private int prize;
    private String message;

    Rank(int countOfMatch, int prize, MessageFormat messageFormat) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.message = messageFormat.getFormatMessage(countOfMatch, prize);
    }

    public static Rank valueOf(int countOfMatch) {

        for (Rank rank : values()) {
            if(rank.isSecond()) {
                continue;
            }

            if(rank.isSameCount(countOfMatch)) {
                return rank;
            }
        }

        return Rank.MISS;
    }

    private boolean isSecond() {
        return this == SECOND;
    }

    public boolean isMiss() {
        return this == MISS;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getTotalPrize(int matchCount) {
        return this.prize * matchCount;
    }

    private boolean isSameCount(int key) {
        return this.countOfMatch == key;
    }

    private enum MessageFormat {

        COMMON("%d개 일치 (%d원)"),
        BONUS("%d개 일치, 보너스 볼 일치(%d원)");

        private String format;

        MessageFormat(String format) {
            this.format = format;
        }

        private String getFormatMessage(int countOfMatch, int prize) {
            return String.format(this.format, countOfMatch, prize);
        }

    }
}
