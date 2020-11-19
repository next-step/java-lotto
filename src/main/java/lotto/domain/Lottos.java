package lotto.domain;

import lotto.exception.BadNumOfManualLottosException;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class Lottos {
    private static final Money lottoPrice = new Money(1000);

    private final Money purchaseMoney;
    private final List<Lotto> manualLottos;
    private final List<Lotto> autoLottos;

    public Lottos(int purchaseMoney, List<Lotto> manualLottos, Supplier<Lotto> autoSupplier) {
        this.purchaseMoney = new Money(purchaseMoney);
        this.manualLottos = manualLottos;
        validate();
        autoLottos = new LinkedList<>();
        for (int i = 0; i < getNumOfAutoLottos(); i++) {
            autoLottos.add(autoSupplier.get());
        }
    }

    public Result getResult(Lotto winningLotto, LottoNo bonus) {
        Result result = new Result();
        for (Lotto lotto : manualLottos) {
            result.increaseNumOfLotto(lotto, winningLotto, bonus);
        }
        for (Lotto lotto : autoLottos) {
            result.increaseNumOfLotto(lotto, winningLotto, bonus);
        }
        return result;
    }

    public Money getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getNumOfManualLottos() {
        return manualLottos.size();
    }

    int getNumOfTotalLottos() {
        return (int) purchaseMoney.divide(lottoPrice);
    }

    public int getNumOfAutoLottos() {
        return getNumOfTotalLottos() - getNumOfManualLottos();
    }

    private void validate() {
        if (getNumOfTotalLottos() < getNumOfManualLottos()) {
            throw BadNumOfManualLottosException.getInstance();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : manualLottos) {
            sb.append(lotto);
            sb.append(System.lineSeparator());
        }
        for (Lotto lotto : autoLottos) {
            sb.append(lotto);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
