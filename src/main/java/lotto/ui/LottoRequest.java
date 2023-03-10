package lotto.ui;

import lotto.domain.enums.LottoType;

public class LottoRequest {
    private final int price;
    private final String type;

    public LottoRequest(int price, String type) {
        this.price = price;
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "LottoRequest{" +
                "price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
