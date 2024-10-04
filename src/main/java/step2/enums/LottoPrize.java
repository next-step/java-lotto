package step2.enums;

import java.util.Arrays;

public enum LottoPrize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    private final int matchCount;
    private final int prizeMoney;

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    //로또 숫자 일치 카운트와, 로또의 개수를 입력받으면 총 당첨금액을 내려준다.
    public static int calculateTotalPrize(int matchCount, int count) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.getMatchCount() == matchCount)
                .map(prize -> prize.getPrizeMoney() * count)
                .findFirst()
                .orElse(0);
    }
}
