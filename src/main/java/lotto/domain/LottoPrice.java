package lotto.domain;

public class LottoPrice {
    public static final int LOTTO_PRICE = 1000;

    private final int price;
    private final int totalCount;

    public LottoPrice(int price) {
        if (price < LOTTO_PRICE || price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 가능합니다.");
        }
        this.price = price;
        this.totalCount = price / LOTTO_PRICE;
    }

    public boolean validManualCount(int manualCount) {
        return manualCount <= totalCount && manualCount >= 0;
    }

    public int buyManualLottoCount(int manualCount) {
        return totalCount - manualCount;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
