package lottery.domain;

import java.util.Arrays;

public enum LotteryValue {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FORTH_PLACE(3, 5_000);

    private final int place;
    private final int amount;

    LotteryValue(int place, int amount) {
        this.place = place;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static LotteryValue findByAmount(int place) {
        return Arrays.stream(LotteryValue.values())
                .filter(v -> place == v.place)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(
                        String.format("%d에 해당하는 당첨금액은 없습니다.", place)));
    }
}
