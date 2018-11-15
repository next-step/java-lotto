package lotto;

public class Money {
    private static final int DEFAULT_PRICE = 1000;
    private int price;

    public Money(int price) {
        this.price = price;
        if (isCorrect()) {
            throw new IllegalArgumentException(DEFAULT_PRICE + "원 단위로 입력할 수 있습니다.");
        }
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuntity() {
        return this.price / DEFAULT_PRICE;
    }

    private boolean isCorrect() {
        return 0 < (price % DEFAULT_PRICE);
    }
}
