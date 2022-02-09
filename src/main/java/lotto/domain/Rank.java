package lotto.domain;

import java.util.Arrays;


public enum Rank {

    FIRST(6, 200000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0,0);


    private final int matchCount;
    private final Money prize;


    Rank(final int matchCount,final int prize) {
        this.matchCount = matchCount;
        this.prize = new Money(prize);
    }

    public static Rank countMatch(final Winning winning, final Lotto lotto){
        int lottoCount = (int) winning.winningLottoNumber(lotto);
        boolean bonusBallMatch = winning.bonusLottoNumber(lotto);
        if (THIRD.match(lottoCount) && !bonusBallMatch) {
            return THIRD;
        }
        return Arrays.stream(Rank.values()).filter(rank -> rank.match(lottoCount)).findFirst()
            .orElse(NOTHING);
    }

    public boolean match(final int count){
        return matchCount == count;
    }

    public static boolean get(Rank rank){
        return rank!=rank.NOTHING;
    }
    public int getMatchCount() {
        return matchCount;
    }

    public Money getPrize() {
        return prize;
    }
    public Money getPrize(final int hit){
        return new Money(prize.getValue()).multiple(hit);
    }
}

