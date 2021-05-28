package lotto.domains;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {}

    public static Lottos makeLottos(Cash cash) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < cash.numberOfPurchasesAvailable(); i++) {
            lottoList.add(new Lotto());
        }
        return new Lottos(lottoList);
    }
}
