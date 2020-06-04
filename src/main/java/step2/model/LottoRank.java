package step2.model;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public final static List<LottoRank> WINNING_RANKS = Collections.unmodifiableList(Arrays.asList(
            FIRST,
            SECOND,
            THIRD,
            FOURTH,
            FIFTH
    ));

    private final int countOfMatch;
    private final int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank findRank(int countOfMatch, boolean matchBonus) {
        LottoRank lottoRank = Arrays.stream(values())
                .filter(rank -> rank.isMatch(countOfMatch))
                .findFirst()
                .orElse(MISS);

        if (isRequireBonusMatch(matchBonus, lottoRank)) {
            return THIRD;
        }

        return lottoRank;
    }

    private static boolean isRequireBonusMatch(boolean matchBonus, LottoRank lottoRank) {
        return LottoRank.SECOND.equals(lottoRank) && !matchBonus;
    }

    private boolean isMatch(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}개 일치 ({1}원)", countOfMatch, winningMoney);
    }
}
