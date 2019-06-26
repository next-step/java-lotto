package lotto.model;

import java.util.List;

public class PurchaseRequest {

    public static final int MIN_MANUAL_LOTTO_SIZE = 0;
    private Money money;
    private List<String> manualLottoInfo;

    PurchaseRequest(Money money, List<String> manualLottoInfo) {
        this.money = money;
        this.manualLottoInfo = manualLottoInfo;
    }

    public static PurchaseRequest of(Money money, List<String> manualLottoInfo) {
        return new PurchaseRequest(money, manualLottoInfo);
    }

    public boolean hasManualLotto() {
        return !(manualLottoInfo == null || manualLottoInfo.isEmpty());
    }

    public int countOfManualLotto() {
        return hasManualLotto() ? manualLottoInfo.size() : MIN_MANUAL_LOTTO_SIZE;
    }

    public void spend(Money money) {
        this.money = this.money.subtract(money);
    }

    public Money getMoney() {
        return money;
    }

    public List<String> getManualLottoInfo() {
        return manualLottoInfo;
    }
}