package lottery.domain;

import java.util.Objects;

public class LotteryAmount {
    public static final int LOTTERY_PRICE = 1000;
    private final int auto;
    private final int manual;

    public LotteryAmount(int price, int numberOfManual) {
        if (price < LOTTERY_PRICE) {
            this.auto = 0;
            throw new IllegalArgumentException("로또 1장의 가격은 " + LOTTERY_PRICE + "입니다.");
        }

        if (price - (numberOfManual * LOTTERY_PRICE) <= 0) {
            this.auto = 0;
            this.manual = 0;
            throw new IllegalArgumentException("수동 로또 구매가 구입가격을 초과했습니다.");
        }
        this.auto = (price / LOTTERY_PRICE) - numberOfManual;
        this.manual = numberOfManual;
    }

    public int getAuto() {
        return auto;
    }
    public int getManual() { return manual; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryAmount that = (LotteryAmount) o;
        return auto == that.auto &&
                manual == that.manual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(auto, manual);
    }
}
