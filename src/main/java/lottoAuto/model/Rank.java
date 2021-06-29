package lottoAuto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    private int numberOfWinnings;
    private int prize;

    Rank(int numberOfWinnings, int prize) {
        this.numberOfWinnings = numberOfWinnings;
        this.prize = prize;
    }

    public static Rank findByRank(LottoResult lottoResult) {
        if (lottoResult.getCount() == SECOND.numberOfWinnings && lottoResult.getHasBonusBall()) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.numberOfWinnings == lottoResult.getCount() && !lottoResult.getHasBonusBall())
                .findAny()
                .orElse(NO_MATCH);
    }

    public static String makeMessage(Rank rank){
        return rank.numberOfWinnings+"개 일치 ("+rank.prize+"원)";
    }

    public static int calculatePrize(Rank rank, Long count) {
        return rank.prize * Integer.valueOf(String.valueOf(count));
    }
}
