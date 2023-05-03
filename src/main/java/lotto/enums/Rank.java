package lotto.enums;

import java.util.Arrays;

public enum Rank {

    FIRST_PLACE(6, 2_000_000_000),
    BONUS_PLACE(5, 30_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    LOST(0, 0);

    private static final int MIN_WIN_COUNT = 3;
    private int winCount;
    private int prize;

    Rank(int winCount, int prize) {
        this.winCount = winCount;
        this.prize = prize;
    }

    public static Rank of(int winCount, boolean bonusWin) {
        if (winCount < MIN_WIN_COUNT) {
            return LOST;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.winCount == winCount)
                .map(rank -> checkBonusWin(rank, bonusWin))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("당첨된 번호의 갯수가 범위에서 벗어낫습니다."));
    }

    public static Rank checkBonusWin(Rank rank, boolean bonusWin) {
        if (bonusWin) {
            return BONUS_PLACE;
        }
        if (rank.winCount == SECOND_PLACE.winCount) {
            return SECOND_PLACE;
        }
        return rank;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getPrize() {
        return prize;
    }
}
