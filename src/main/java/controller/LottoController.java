package controller;

public class LottoController {
    private int price;


    public LottoController(int price) {
        this.price = price;
    }

    public int getLottoQuantity() {
        return price / 1000;
    }
}
