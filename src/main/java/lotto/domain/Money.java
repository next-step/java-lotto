package lotto.domain;

public class Money {
    private final int price;

    public Money(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("입력 가능 금액은 0원 이상입니다.");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
