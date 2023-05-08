package step2;

public class PurchaseInfomationDto {

    private final int money;
    private final int manualLottoCount;

    public PurchaseInfomationDto(int money, int manualLottoCount) {
        this.money = money;
        this.manualLottoCount = manualLottoCount;
    }

    public int getMoney() {
        return money;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
