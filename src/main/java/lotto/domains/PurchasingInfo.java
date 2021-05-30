package lotto.domains;

import java.util.List;

public class PurchasingInfo {
    /*
    *TODO
    * 자동로또 갯수
    * 수동로또 갯수
    * 구입금액 밸리데이션체크
    *
     */
    private final Cash cash;
    private final int manualLottoCount;
    private final List<String> manualLottoList;

    public PurchasingInfo(Cash cash, int manualLottoCount, List<String> manualLottos) {
        this.cash = cash;
        validateLottoCount(manualLottoCount);
        this.manualLottoCount = manualLottoCount;
        this.manualLottoList = manualLottos;
    }

    public PurchasingInfo(int cash, int manualLottoCount, List<String> manualLottos) {
        this(new Cash(cash),manualLottoCount,manualLottos);
    }

    private void validateLottoCount(int manualLottoCount) {
        if(manualLottoCount < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        if (manualLottoCount > cash.numberOfPurchasesAvailable()) {
            throw new IllegalArgumentException("구입가능금액을 넘었습니다.");
        }
    }

    public List<String> manualLottoList() {
        return manualLottoList;
    }

    public int manualLottoCount() {
        return this.manualLottoCount;
    }

    public int autoLottoCount() {
        return cash.numberOfPurchasesAvailable() - manualLottoCount;
    }
}
