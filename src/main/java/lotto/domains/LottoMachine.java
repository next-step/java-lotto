package lotto.domains;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;

    public Lottos buyLottos(Cash cash) {
        return makeLottos(cash);
    }

    private Lottos makeLottos(Cash cash) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < cash.numberOfPurchasesAvailable(new Cash(LOTTO_PRICE)); i++) {
            lottoList.add(new Lotto());
        }
        return new Lottos(lottoList);
    }
}
