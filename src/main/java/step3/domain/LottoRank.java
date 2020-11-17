package step3.domain;

import step3.exception.NotMatchRankException;

import java.util.Arrays;
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


    public static LottoRank valueOf(int countOfMatch, boolean matchBonusNumber) {
        validMatch(countOfMatch);

        if (findSecond(countOfMatch, matchBonusNumber)) return THIRD;


        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.match == countOfMatch)
                .findAny()
                .orElse(MISS);
    }

    private static boolean findSecond(int countOfMatch, boolean matchBonusNumber) {
        if (countOfMatch == 5 && !matchBonusNumber) {
            return true;
        }
        return false;
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
