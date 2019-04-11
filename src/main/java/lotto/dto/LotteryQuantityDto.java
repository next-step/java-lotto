package lotto.dto;

public class LotteryQuantityDto {
    private String totalQuantity;

    public LotteryQuantityDto(int totalQuantity) {
        this(String.valueOf(totalQuantity));
    }

    public LotteryQuantityDto(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }


}
