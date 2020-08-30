package step4.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    private final Money money;
    private final List<Lotto> manualLottos;
    private final List<Lotto> autoLottos;

    public LottoMachine(int money, int[][] manualLottoNos) {
        this.money = new Money(money);
        this.manualLottos = Arrays.stream(manualLottoNos)
                .map(LottoFactory::createByLottoNos)
                .collect(Collectors.toList());
        int purchaseCount = this.money.calculateLottoPurchaseCount();
        this.autoLottos = LottoFactory.createsByLottoPurchaseCount(purchaseCount - manualLottos.size());
    }

    public int getManualLottosSize() {
        return manualLottos.size();
    }

    public int getAutoLottosSize() {
        return autoLottos.size();
    }

    public List<Lotto> issue() {
        return Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
    }

}
