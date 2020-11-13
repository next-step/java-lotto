package step2.domain;

import step2.exception.NotMatchRankException;

import java.util.stream.Stream;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    MISS(0, 0);

    private final int match;
    private final int price;

    LottoRank(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public static int matchLottoRankPrice(int match) {
        validMatch(match);

        return Stream.of(FORTH, THIRD, SECOND, FIRST)
                .filter(ranking -> ranking.match == match)
                .findFirst()
                .orElse(MISS)
                .getMatchPrice();
    }

    public static LottoRank valueOf(int match) {
        validMatch(match);

        return Stream.of(FORTH, THIRD, SECOND, FIRST)
                .filter(ranking -> ranking.match == match)
                .findFirst()
                .orElse(MISS);

    }

    private static void validMatch(int match) {
        if (match > 6 || match < 0) {
            throw new NotMatchRankException();
        }
    }

    private int getMatchPrice() {
        return price;
    }

    public int getPrice() {
        return price;
    }


}
