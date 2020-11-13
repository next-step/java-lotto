package step2.domain;

import step2.exception.NotMatchRankException;

import java.util.stream.Stream;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(4, 1_500_000),
    THIRD(3, 50_000),
    FORTH(2, 5_000),
    MISS(0, 0);

    private final int match;
    private final int price;

    LottoRank(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public static int matchLottoRankPrice(int match) {
        return Stream.of(MISS, FORTH, THIRD, SECOND, FIRST)
                .filter(ranking -> ranking.match == match)
                .findFirst()
                .orElseThrow(NotMatchRankException::new)
                .getMatchPrice();
    }

    private int getMatchPrice() {
        return price;
    }
    public int getPrice(){
        return price;
    }


}
