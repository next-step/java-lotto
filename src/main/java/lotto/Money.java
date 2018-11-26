package lotto;

public class Money {
    private static final int DEFAULT_PRICE = 1_000;
    private int price;

    public Money(int price) {
        if (isCorrect(price)) {
            throw new IllegalArgumentException(DEFAULT_PRICE + "원 단위로 입력할 수 있습니다.");
        }
        this.price = price;
    }
    
    public int getQuntity() {
        return this.price / DEFAULT_PRICE;
    }

    public double earningRate(double earning) {
        return earning / this.price;
    }

    private boolean isCorrect(int price) {
        return 0 < (price % DEFAULT_PRICE);
    }
}
