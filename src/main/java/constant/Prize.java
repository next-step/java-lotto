package constant;

public enum Prize {
    FIRST(new Rank(6)),
    SECOND(new Rank(5)),
    THIRD(new Rank(4)),
    FOURTH(new Rank(3)),
    UNKNOWN(new Rank(0));

    public final Rank rank;

    Prize(Rank rank) {
        this.rank = rank;
    }

    public int getPrize() {
        switch ((int) rank.getCountOfMatchedNumber()) {
            case 3:
                return 5000;
            case 4:
                return 50000;
            case 5:
                return 1500000;
            case 6:
                return 2000000000;
            default:
                return 0;
        }
    }
}
