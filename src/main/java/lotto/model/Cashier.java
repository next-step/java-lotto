package lotto.model;

public class Cashier {
    private static final int LOTTO_PRICE = 1_000;

    private int price;
    private int lottoQuantity;
    private int autoQuantity;
    private int manualQuantity;

    public Cashier(int price) {
        this.price = price;
        lottoQuantity = price / LOTTO_PRICE;
    }

    public void calculateAutoLottoQuantity(int manualQuantity) {
        autoQuantity = lottoQuantity - manualQuantity;
        this.manualQuantity = manualQuantity;
    }

    public int getPrice() {
        return price;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }

    public int getAutoQuantity() {
        return autoQuantity;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }
}
