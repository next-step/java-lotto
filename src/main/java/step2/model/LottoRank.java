package step2.model;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum LottoRank {

    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final static List<LottoRank> WINNING_GROUP = Arrays.asList(FOURTH, THIRD, SECOND, FIRST);

    private final int matchCount;
    private final int winningMoney;

    LottoRank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoRank findRank(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> isMatch(matchCount, lottoRank))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isMatch(int matchCount, LottoRank lottoRank) {
        return lottoRank.getMatchCount() == matchCount;
    }

    public static List<LottoRank> getWinningRank() {
        return Collections.unmodifiableList(WINNING_GROUP);
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}개 일치 ({1}원)", matchCount, winningMoney);
    }
}
