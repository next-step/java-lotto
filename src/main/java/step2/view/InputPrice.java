package step2.view;

import step2.domain.lotto.Price;

public class InputPrice {
    private final Price price;

    public InputPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
