package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoGame buyLottoGame(PurchaseMoney purchaseMoney, List<String[]> manualNumbers) {

        List<Lotto> auto = IntStream.range(0, purchaseMoney.getAutoCount())
                .mapToObj(a -> LottoAutoMaker.makeLotto())
                .collect(Collectors.toList());

        List<Lotto> manual = manualNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        auto.addAll(manual);

        return new LottoGame(auto);

    }
}
