package lottery.domain;

import java.util.Arrays;

public enum LotteryValue {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FORTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    NO_PLACE(-1, 0);

    private final int place;
    private final int amount;

    LotteryValue(int place, int amount) {
        this.place = place;
        this.amount = amount;
    }

    public int getPlace() {
        return place;
    }
    public int getAmount() {
        return amount;
    }

    public static LotteryValue findByAmount(int place) {
        return Arrays.stream(LotteryValue.values())
                .filter(v -> place == v.place)
                .findFirst().orElse(LotteryValue.NO_PLACE);
    }

    public static LotteryValue confirmPlace(int key, boolean matchedBonusNumber) {
        if (key == THIRD_PLACE.getPlace() && matchedBonusNumber) {
            return SECOND_PLACE;
        }
        return findByAmount(key);
    }

    public static boolean isNoPlace(LotteryValue place) {
        return place == NO_PLACE;
    }
}
