package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoStore.LOTTO_PRICE;

public class LottoCount {
    private static final int MINIMUM_ISSUE_COUNT = 1;
    private static final String NOT_VALID_ISSUE_COUNT = "로또 발급은 %d개 이상 가능합니다.";

    private final int count;

    public LottoCount(int count) {
        this.count = count;
    }

    public static LottoCount of(int count) {
        return new LottoCount(count);
    }

    public int calculateCount(int price) {
        return purchaseCount(price) - count;
    }

    public int purchaseCount(int price) {
        int amount = price / LOTTO_PRICE;
        validate(amount);
        return amount;
    }

    public int getCount() {
        return count;
    }

    private void validate(int count) {
        if (count < MINIMUM_ISSUE_COUNT) {
            throw new IllegalArgumentException(String.format(NOT_VALID_ISSUE_COUNT, MINIMUM_ISSUE_COUNT));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
