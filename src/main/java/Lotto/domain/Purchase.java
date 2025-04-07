package Lotto.domain;

import Lotto.utils.ValidationUtils;

public class Purchase {
    public static final int UNIT = 1000;
    private int price = 0;
    private int quantity;

    public Purchase(int price) {
        this.price = price;
        this.quantity = purchaseLotto(price);
    }

    private int purchaseLotto(int price) {
        return price / UNIT;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public static boolean isInvalidPrice(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }

        String sanitizedInput = input.replace(",", "");
        return ValidationUtils.isInvalidNumber(sanitizedInput, UNIT, Integer.MAX_VALUE) ||
                Integer.parseInt(sanitizedInput) % UNIT != 0;
    }
}
