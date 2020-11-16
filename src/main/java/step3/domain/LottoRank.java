package step3.domain;

import step3.exception.NotMatchRankException;

import java.util.stream.Stream;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),

    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int match;
    private final int price;

    LottoRank(int match, int price) {
        this.match = match;
        this.price = price;
    }


    public static LottoRank valueOf(int match) {
        validMatch(match);

        return Stream.of(FIFTH , FORTH, THIRD, SECOND, FIRST)
                .filter(ranking -> ranking.match == match)
                .findFirst()
                .orElse(MISS);
    }


    public GameMoney prize(int countOfMatchLotto) {
        return new GameMoney(countOfMatchLotto * price);
    }


    private static void validMatch(int match) {
        if (match > 6 || match < 0) {
            throw new NotMatchRankException();
        }
    }

    public int getPrice() {
        return price;
    }


    public int getMatch() {
        return match;
    }



}
