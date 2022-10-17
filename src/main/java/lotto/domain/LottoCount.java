package lotto.domain;

public class LottoCount {
    private static final int MIN_PRICE = 1000;

    private final int count;

    public LottoCount(int price) {
        if (price < MIN_PRICE || price % MIN_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 가능합니다.");
        }
        this.count = price / MIN_PRICE;
    }

    public int getCount() {
        return count;
    }
}
