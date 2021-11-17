package domain;

import java.util.Arrays;

public enum RankCalculation {
    FIRST_RANK(6, 1),
    SECOND_RANK(5, 2),
    THIRD_RANK(4, 3),
    FOURTH_RANK(3, 4),
    ZERO(0, 0);

    private static final String RANK_ERROR_MESSAGE = "error : 당첨 개수를 확인해주세요.";
    private int winningNumber;
    private int ranking;

    RankCalculation(int winningNumber, int ranking) {
        this.winningNumber = winningNumber;
        this.ranking = ranking;
    }

    public static int ranking(int winningNumber) {
        return getRanking(winningNumber).ranking;
    }

    private static RankCalculation getRanking(int winningNumber) {
        return Arrays.stream(values())
                .filter(o -> o.winningNumber == winningNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RANK_ERROR_MESSAGE));
    }
}
