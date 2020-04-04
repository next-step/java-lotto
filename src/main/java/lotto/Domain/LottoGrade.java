package lotto.Domain;


import java.util.Arrays;
import java.util.Objects;

public enum  LottoGrade {
    MISS(0,  false,  0),
    WIN5TH(3, false, 5_000),
    WIN4TH(4, false, 50_000),
    WIN3RD(5, false, 1_500_000),
    WIN2ND(5, true, 30_000_000),
    WIN1ST(6, false, 2_000_000_000);

    final private int matchCount;
    final private boolean matchBonus;
    final private int prize;

    LottoGrade(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }

    private static boolean conditionOfGrade(LottoGrade lottoGrade, int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return Objects.equals(lottoGrade.getMatchCount(), matchCount)
                    && Objects.equals(lottoGrade.getMatchBonus(), matchBonus);
        }
        return Objects.equals(lottoGrade.getMatchCount(), matchCount);
    }

    public static LottoGrade findGrade(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoGrade.values())
                .filter(lottoGrade -> conditionOfGrade(lottoGrade, matchCount, matchBonus))
                .findFirst()
                .orElse(MISS);
    }
}
