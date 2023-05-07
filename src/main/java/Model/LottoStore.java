package model;

public class LottoStore {
    private static int LOTT_PRICE = 1000;
    private int buyAmount;

    public LottoStore(int buyAMount) {
        this.buyAmount = buyAMount;
    }

    public int getCount() {
        return this.buyAmount / this.LOTT_PRICE;
    }
}
