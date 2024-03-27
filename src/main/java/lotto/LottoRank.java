package lotto;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSE(0, 0);

    private int count;
    private int prize;

    private static final int LOSE_STANDARD = 3;

    LottoRank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank isLottoRank(int count) {
        if (count < LOSE_STANDARD) {
            return LOSE;
        }
        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.getCount() == count)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("허용되지 않는 숫자입니다."));
    }

}
