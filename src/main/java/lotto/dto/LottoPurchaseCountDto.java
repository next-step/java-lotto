package lotto.dto;

public class LottoPurchaseCountDto {
    private final int autoAmount;
    private final int manualAmount;

    public LottoPurchaseCountDto(int autoAmount, int manualAmount) {
        this.autoAmount = autoAmount;
        this.manualAmount = manualAmount;
    }

    public int getAutoAmount() {
        return autoAmount;
    }

    public int getManualAmount() {
        return manualAmount;
    }
}
