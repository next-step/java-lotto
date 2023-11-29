package step2;

import java.util.Arrays;

public enum Prize {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    UNKNOWN(0);

    private final int WIN_PRIZE_THREE = 5000;
    private final int WIN_PRIZE_FOUR = 50000;
    private final int WIN_PRIZE_FIVE = 1500000;
    private final int WIN_PRIZE_SIX = 2000000000;
    private final int value;

    Prize(int value) {
        this.value = value;
    }

    public int calculatePrize(Prize prize, int matchCount){
        int result = 0;
        switch (prize){
            case THREE:
                result = matchCount*WIN_PRIZE_THREE;
                break;
            case FOUR:
                result = matchCount*WIN_PRIZE_FOUR;
                break;
            case FIVE:
                result = matchCount*WIN_PRIZE_FIVE;
                break;
            case SIX:
                result = matchCount*WIN_PRIZE_SIX;
                break;
        }
        return result;
    }

    static Prize of(int value) {
        return Arrays.stream(values())
                .filter(v -> value == (v.value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("해당 값을 찾을 수 없습니다.")));
    }

}
