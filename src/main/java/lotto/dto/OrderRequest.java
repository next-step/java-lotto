package lotto.dto;

public class OrderRequest {

    private final int money;

    public OrderRequest(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
