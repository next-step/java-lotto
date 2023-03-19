package lotto;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    ETC(0, 0);

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if(matchCount == 6) {
            return FIRST;
        }
        if(matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if(matchCount == 5 && !bonusMatch) {
            return THIRD;
        }
        if(matchCount == 4) {
            return FOURTH;
        }
        if(matchCount == 3) {
            return FIFTH;
        }
        return ETC;
    }


}
