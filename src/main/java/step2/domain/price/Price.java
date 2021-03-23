package step2.domain.price;

public enum Price {

    MISS("MISS", 0),
    FIFTH("FIFTH", 5000),
    FORTH("FORTH", 50000),
    THIRD("THIRD", 1500000),
    SECOND("SECOND", 30000000),
    FIRST("FIRST", 2000000000);

    private String rank;
    private int prize;

    Price(String rank, int price) {
        this.rank = rank;
        this.prize = price;
    }

    public String getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public static Price price(int matchCount, boolean bonusMatch) {
        if (thirdPriceOrAbove(matchCount)) {
            return convertToHighPrice(matchCount, bonusMatch);
        }
        return convertToLowPrice(matchCount);
    }

    private static boolean thirdPriceOrAbove(int countOfMatch) {
        return countOfMatch >= 5;
    }

    private static Price convertToHighPrice(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 6) {
            return Price.FIRST;
        }
        if (countOfMatch == 5 && matchBonus) {
            return Price.SECOND;
        }
        return Price.THIRD;
    }

    private static Price convertToLowPrice(int countOfMatch) {
        if (countOfMatch == 4) {
            return Price.FORTH;
        }
        if (countOfMatch == 3) {
            return Price.FIFTH;
        }
        return Price.MISS;
    }

}
