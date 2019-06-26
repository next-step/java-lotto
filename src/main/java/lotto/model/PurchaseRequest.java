package lotto.model;

import java.util.List;

public class PurchaseRequest {

    public static final int MIN_MANUAL_LOTTO_SIZE = 0;
    private Money money;
    private List<String> manualLottoInfo;

    private PurchaseRequest(Money money, List<String> manualLottoInfo) {
        this.money = money;
        this.manualLottoInfo = manualLottoInfo;
    }

    public static PurchaseRequest of(Money money, List<String> manualLottoInfo) {
        if (hasManualLotto(manualLottoInfo)) {
            money = money.subtract(Money.calculateTotalByLotto(manualLottoInfo.size()));
        }
        return new PurchaseRequest(money, manualLottoInfo);
    }

    private static boolean hasManualLotto(List<String> manualLottoInfo) {
        return !(manualLottoInfo == null || manualLottoInfo.isEmpty());
    }

    public boolean hasManualLotto() {
        return hasManualLotto(manualLottoInfo);
    }

    public int countOfManualLotto() {
        return hasManualLotto() ? manualLottoInfo.size() : MIN_MANUAL_LOTTO_SIZE;
    }

    public int countOfRandomLotto() {
        return money.countAvailableByLotto() - countOfManualLotto();
    }

    public Money getMoney() {
        return money;
    }

    public List<String> getManualLottoInfo() {
        return manualLottoInfo;
    }

}