package lotto.domain;

import java.util.List;

public class LottoOrder {
    private Money payment;
    private List<String> manualLottos;

    public LottoOrder(Money payment, List<String> manualLottos) {
        verifyAvailablePurchase(payment, manualLottos);
        this.payment = payment;
        this.manualLottos = manualLottos;
    }

    private static void verifyAvailablePurchase(Money payment, List<String> manualLottos) {
        if (payment.isNotEnoughForPurchase()) {
            throw new RuntimeException("금액이 부족하여 로또를 구매할 수 없습니다.");
        }

        if (manualLottos.size() > payment.calculateNumberOfLottoAvailableForPurchase()) {
            throw new RuntimeException("지불한 금액을 초과하여 수동 구매할 수 없습니다.");
        }
    }

    public int getNumberOfAutoLottos() {
        return payment.calculateNumberOfLottoAvailableForPurchase() - manualLottos.size();
    }

    public int getNumberOfManualLottos() {
        return manualLottos.size();
    }

    public List<String> getManualLottos() {
        return manualLottos;
    }
}
