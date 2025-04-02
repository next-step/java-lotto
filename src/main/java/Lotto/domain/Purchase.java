package Lotto.domain;

public class Purchase {
    private static final int UNIT = 1000;
    private int price = 0;
    private int quantity;

    public Purchase(int price) {
        this.price = price;
        this.quantity = purchaseLotto(price);
    }

    private int purchaseLotto(int price) {
        return price / UNIT;
    }

    public static boolean isInvalidPrice(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }

        try {
            String sanitizedInput = input.replace(",", "");
            int price = Integer.parseInt(sanitizedInput);
            if(price < 0 || price < UNIT || price % UNIT != 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }


    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
