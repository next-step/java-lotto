package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoGame buyLottoGame(PurchaseMoney purchaseMoney, List<String[]> manualNumbers) {

        return new LottoGame(IntStream.range(0, purchaseMoney.getLottoCount())
                .mapToObj(a -> LottoAutoMaker.makeLotto())
                .collect(Collectors.toList()));

    }
}
