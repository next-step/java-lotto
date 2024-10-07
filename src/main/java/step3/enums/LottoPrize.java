package step3.enums;

import java.util.Arrays;

public enum LottoPrize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_BONUS_MATCH(5, 30000000),
    SIX_MATCH(6, 2000000000);

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    private final static String NOT_MATCH_COUNT = "일치하는 당첨 등수가 없습니다.";
    private final static int BONUS_MATCH_COUNT = 5;
    private final int matchCount;
    private final int prizeMoney;

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    //일치 번호수와 보너스번호 일치 여부를 받아 LottoPrize를 내려준다.
    public static LottoPrize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == BONUS_MATCH_COUNT && matchBonus) { //보너스로 6개가 일치했을 경우
            return FIVE_BONUS_MATCH;
        }
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.getMatchCount() == matchCount && !(matchCount == BONUS_MATCH_COUNT && prize == FIVE_BONUS_MATCH))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_COUNT));
    }
}
