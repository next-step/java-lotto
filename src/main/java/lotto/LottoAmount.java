package lotto;

import java.util.Arrays;

public enum LottoAmount {
    FIT_0(0, 0),
    FIT_1(0, 1),
    FIT_2(0, 2),
    FIT_3(5_000,3 ),
    FIT_4(50_000, 4),
    FIT_5(1_500_000, 5),
    FIT_6(2_000_000_000, 6);

    private int amount;
    private int fitCount;

    private LottoAmount(int amount, int fitCount) {
        this.amount = amount;
        this.fitCount = fitCount;
    }

    public int getAmount() {
        return amount;
    }

    public static LottoAmount getByFitCount(int fitCount) {
        if (fitCount < 1 || fitCount > 6) {
            throw new IndexOutOfBoundsException("the fitCount must be between 1 and 6");
        }

        return Arrays.stream(values())
                .filter(amount -> amount.fitCount == fitCount)
                .findFirst()
                .get();
    }
}
