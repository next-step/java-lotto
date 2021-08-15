package lottery.dto;

public class LotteryQuantityDto {

    private final int quantity;

    public LotteryQuantityDto(final int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
