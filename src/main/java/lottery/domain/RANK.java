package lottery.domain;

import lombok.ToString;

@ToString
public enum RANK {
    MISS(0, 0, "0개"),
    FIFTH(3, 5_000, "3개"),
    FOURTH(4, 5_0000, "4개"),
    THIRD(5, 1_500_000, "5개"),
    SECOND(5, 3_000_000, "5개 일치, 보너스 볼"),
    FIRST(6, 2_000_000_000, "6개");

    private int matched;
    private int price;
    private String matchedInfo;

    RANK(int matched, int price, String matchedInfo) {
        this.matched = matched;
        this.price = price;
        this.matchedInfo = matchedInfo;
    }

    public int getMatched() {
        return matched;
    }

    public int getPrice() {
        return price;
    }

    public String getMatchedInfo() {
        return matchedInfo;
    }
}