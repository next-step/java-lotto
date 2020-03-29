package lotto;

public class InputView {
    private static final int MIN_PRICE = 1000;
    private final int price;

    public InputView(int price) {
        this.price = valdatePrice(price);
    }

    private int valdatePrice(int price) {
        if (price > MIN_PRICE) {
            return price;
        }

        throw new IllegalArgumentException("1000원보다 큰 값을 입력해야합니다.");
    }
}
