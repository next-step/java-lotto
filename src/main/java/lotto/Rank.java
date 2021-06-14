package lotto;

public enum Rank {
    FIRST(6, false, "2000000000"),
    SECOND(5, true, "30000000"),
    THIRD(5, false, "1500000"),
    FOURTH(4, false, "50000"),
    FIFTH(3, false, "5000"),
    MISS(2, false, "0");

    private int matchCount;
    private boolean hasBonusBall;
    private String price;

    Rank(int matchCount, boolean hasBonusBall, String price){
        this.matchCount = matchCount;
        this.hasBonusBall = hasBonusBall;
        this.price = price;
    }

    public static Rank of(int matchCount, boolean hasBonusBall) {
        for(Rank rank : Rank.values()) {
            if (matchCount == rank.getMatchCount()) {
                if(matchCount == 5 && hasBonusBall) {
                    return SECOND;
                }
                if(matchCount == 5){
                    return THIRD;
                }
                return rank;
            }
        }
        return MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonusBall() {
        return hasBonusBall;
    }

    public String getPrice() {
        return price;
    }
}
