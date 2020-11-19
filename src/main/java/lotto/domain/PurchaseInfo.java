package lotto.domain;

import lotto.exception.BadManualLottosException;
import lotto.exception.BadNumOfManualLottosException;

import java.util.List;

public class PurchaseInfo {
    private static final Money lottoPrice = new Money(1000);

    private final Money purchaseMoney;
    private final int numOfManualLottos;
    private final List<Lotto> manualLottos;

    public PurchaseInfo(int purchaseMoney, int numOfManualLottos, List<Lotto> manualLottos) {
        this.purchaseMoney = new Money(purchaseMoney);
        this.numOfManualLottos = numOfManualLottos;
        this.manualLottos = manualLottos;
        validate();
    }

    public Money getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getNumOfManualLottos() {
        return numOfManualLottos;
    }

    List<Lotto> getManualLottos() {
        return manualLottos;
    }

    int getNumOfTotalLottos() {
        return (int) purchaseMoney.divide(lottoPrice);
    }

    public int getNumOfAutoLottos() {
        return getNumOfTotalLottos() - numOfManualLottos;
    }

    private void validate() {
        if (getNumOfTotalLottos() < numOfManualLottos) {
            throw BadNumOfManualLottosException.getInstance();
        }
        if (manualLottos.size() != numOfManualLottos) {
            throw BadManualLottosException.getInstance();
        }
    }
}
