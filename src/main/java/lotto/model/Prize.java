package lotto.model;


import java.util.Arrays;

public enum Prize {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeValue;

    Prize(int matchCount, int prizeValue) {
        this.matchCount = matchCount;
        this.prizeValue = prizeValue;
    }

    public int value() {
        return prizeValue;
    }

    @Override
    public String toString() {
        if (this.equals(SECOND)) {
            return String.format("%d개 일치, 보너스 볼 일치(%s원)", matchCount, prizeValue);
        }
        return String.format("%d개 일치(%s원)", matchCount, prizeValue);
    }

    static Prize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일치 값입니다. " + matchCount + matchBonus));
    }
}
