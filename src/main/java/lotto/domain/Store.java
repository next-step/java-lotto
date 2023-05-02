package lotto.domain;

public class Store {
    private final int PRICE = 1000;


    public int purchase(String budget) {
        return Integer.parseInt(budget) / PRICE;
    }
}
