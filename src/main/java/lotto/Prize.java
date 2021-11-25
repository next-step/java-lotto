package lotto;

import java.util.Arrays;

public enum Prize {
    LOSE(0, 0),
    SEVENTH(1, 0),
    SIXTH(2, 0),
    FIFTH(3, 5000),
    FOURTH(4, 5_0000),
    THIRD(5, 150_0000),
    SECOND(5, 3000_0000),
    FIRST(6, 20_0000_0000);

    private static int CONDITION_REQUIRED_MATCH_COUNT = 5;

    private final int matchCount;
    private final int prize;

    Prize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    /**
     * Prize 는 맞춘개수와 보너스 여부를 판단하여 알맞은 상금을 반환할 수 있다.
     * @param matchCount
     * @param hasBonus
     * @return
     */
    public static Prize of(int matchCount, boolean hasBonus) {
        if (matchCount == CONDITION_REQUIRED_MATCH_COUNT) {
            return secondOrThirdPrize(hasBonus);
        }

        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * matchCount 가 5인 경우 2등과 3등을 구분하기 위한 method
     * @param hasBonus
     * @return
     */
    private static Prize secondOrThirdPrize(boolean hasBonus) {
        if (hasBonus) {
            return SECOND;
        }

        return THIRD;
    }
}

