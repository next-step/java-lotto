package lotto.enums;

import java.util.Arrays;

public enum RANK {

    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    LOST(0, 0);

    private static final int MIN_WIN_COUNT = 3;
    private int winCount;
    private int prize;

    RANK(int winCount, int prize) {
        this.winCount = winCount;
        this.prize = prize;
    }

    public static RANK of(int winCount) {
        if (winCount < MIN_WIN_COUNT) {
            return LOST;
        }
        return Arrays.stream(RANK.values())
                .filter(rank -> rank.winCount == winCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("당첨된 번호의 갯수가 범위에서 벗어낫습니다."));
    }

    public int getWinCount() {
        return winCount;
    }

    public int getPrize() {
        return prize;
    }
}
