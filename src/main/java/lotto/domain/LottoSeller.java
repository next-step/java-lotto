package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoGame buyLottoGame(PurchaseMoney purchaseMoney) {

        return new LottoGame(IntStream.range(0, purchaseMoney.getLottoCount())
                .mapToObj(a -> LottoAutoMaker.makeLotto())
                .collect(Collectors.toList()));

    }
}
