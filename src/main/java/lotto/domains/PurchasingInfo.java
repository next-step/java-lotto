package lotto.domains;

import java.util.List;

public class PurchasingInfo {

    private final Cash cash;
    private final List<String> manualLottoList;

    public PurchasingInfo(Cash cash, List<String> manualLottos) {
        this.cash = cash;
        this.manualLottoList = manualLottos;
    }

    public PurchasingInfo(int cash, List<String> manualLottos) {
        this(new Cash(cash), manualLottos);
    }

    public List<String> manualLottoList() {
        return manualLottoList;
    }

    public int manualLottoCount() {
        return this.manualLottoList.size();
    }

    public int autoLottoCount() {
        return cash.numberOfPurchasesAvailable() - manualLottoList.size();
    }
}
