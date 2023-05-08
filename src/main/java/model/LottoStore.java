package model;

public class LottoStore {
    private static int LOTT_PRICE = 1000;
    private int buyAmount;

    public LottoStore(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public int getCount() {
        return this.buyAmount / this.LOTT_PRICE;
    }
}
