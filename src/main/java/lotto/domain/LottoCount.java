package lotto.domain;

public class LottoCount {
    public static final int LOTTO_PRICE = 1000;

    private final int count;

    public LottoCount(int price) {
        if (price < LOTTO_PRICE || price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 가능합니다.");
        }
        this.count = price / LOTTO_PRICE;
    }

    public int getCount() {
        return count;
    }
}
