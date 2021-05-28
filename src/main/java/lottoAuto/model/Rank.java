package lottoAuto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 (2000000000원)",false),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치(30000000원)",true),
    THIRD(5, 1500000, "5개 일치 (1500000원)",false),
    FORTH(4, 50000, "4개 일치 (50000원)",false),
    FIFTH(3, 5000,"3개 일치 (5000원)", false),
    NO_MATCH(0, 0, "일치 하는 거 없음",false);

    private int matchWinning;
    private int prize;
    private String message;
    private boolean isBonus;

    Rank(int matchWinning, int prize, String message, boolean isBonus) {
        this.matchWinning = matchWinning;
        this.prize = prize;
        this.message = message;
        this.isBonus = isBonus;
    }

    public static Rank findByRank(LottoResult lottoResult) {
        if (lottoResult.getCount() == SECOND.matchWinning && lottoResult.getBonus()) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchWinning == lottoResult.getCount() && !rank.isBonus)
                .findAny()
                .orElse(NO_MATCH);
    }

    public static int getPrize(Rank rank) {
        return rank.prize;
    }

    public static String getMessage(Rank rank) {
        return rank.message;
    }
}
