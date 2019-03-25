package lottogame.domain;

import java.util.Arrays;

import static lottogame.view.ConsoleResultView.BONUS_BALL_MATCHED;

public enum Rank {
    MISS(0, 0, ""),
    FIFTH(3, 5_000, ""),
    FOURTH(4, 50_000, ""),
    THIRD(5, 1_500_000, ""),
    SECOND(5, 30_000_000, BONUS_BALL_MATCHED),
    FIRST(6, 2_000_000_000, "");

    static final int MATCHED_COUNT_TO_CHECK_BONUS_NUMBER = 5;
    static final String WINNING_RESULT_STRING_FORMAT = "%d개 일치, %s(%d원)";

    private final int matchedCount;
    private final long winningMoney;
    private final String winningResultMessage;

    Rank(int matchedCount, long winningMoney, String extraMessage) {
        this.matchedCount = matchedCount;
        this.winningMoney = winningMoney;
        winningResultMessage = createWinningResultString(extraMessage);
    }

    String createWinningResultString(String extraMessage) {
        return String.format(WINNING_RESULT_STRING_FORMAT, matchedCount, extraMessage, winningMoney);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public String getWinningResultMessage() {
        return winningResultMessage;
    }

    public boolean equalsMatchedCount(int matchedCount) {
        return this.matchedCount == matchedCount;
    }

    public static Rank valueOf(MatchStatus matchStatus) {
        return Arrays.stream(values())
                .filter(rank -> rank.equalsMatchedCount(matchStatus.getMatchedCount()))
                .filter(rank -> {
                    if(isBonusNumberCheckSkippable(rank)) {
                        return true;
                    }

                    return isBonusNumberMatched(matchStatus.isBonusNumberMatched(), rank);
                })
                .findFirst()
                .orElse(Rank.MISS);
    }

    static boolean isBonusNumberCheckSkippable(Rank rank) {
        return !rank.equalsMatchedCount(MATCHED_COUNT_TO_CHECK_BONUS_NUMBER);
    }

    static boolean isBonusNumberMatched(boolean isBonusNumberMatched, Rank rank) {
        return (isBonusNumberMatched) ? rank.equals(Rank.SECOND) : rank.equals(Rank.THIRD);
    }
}
