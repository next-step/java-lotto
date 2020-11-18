package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(PurchaseInfo info, Supplier<Lotto> autoSupplier) {
        lottos = new LinkedList<>();
        for (Lotto manualLotto : info.getManualLottos()) {
            lottos.add(manualLotto);
        }
        for (int i = 0; i < info.getNumOfAutoLottos(); i++) {
            lottos.add(autoSupplier.get());
        }
    }

    public Result getResult(WinningCondition condition) {
        Result result = new Result();
        for (Lotto lotto : lottos) {
            result.increaseNumOfLotto(condition, lotto);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
