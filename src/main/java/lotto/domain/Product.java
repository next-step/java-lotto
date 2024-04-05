package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;

public enum Product {
    LOTTO("Lotto", 1000);

    private final String productName;
    private final int price;

    Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public static Product getProduct(String productName) {
        return Arrays.stream(values())
                .filter(m -> m.productName.equals(productName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_PRODUCT.getMessage()));
    }
}
