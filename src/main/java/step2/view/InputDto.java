package step2.view;

public class InputDto {
    private final int price;
    private final int amount;

    public InputDto(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    public int getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }
}
