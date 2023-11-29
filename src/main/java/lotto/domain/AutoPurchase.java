package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoPurchase implements Purchase {

    private static final LottoNumberFactory lottoNumberFactory = LottoNumberFactory.getInstance();

    private final int autoPurchaseCount;

    AutoPurchase(int autoPurchaseCount) {
        this.autoPurchaseCount = autoPurchaseCount;
    }

    @Override
    public List<Lotto> purchase() {
        return createAutoLottoListWithMoney();
    }

    private List<Lotto> createAutoLottoListWithMoney() {
        return IntStream.range(0, autoPurchaseCount)
            .mapToObj(i -> Lotto.auto(lottoNumberFactory.createLottoNumbers()))
            .collect(Collectors.toList());
    }
}

