package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoMachine {

    private static final List<NumberElement> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(NumberElement.create(i));
        }
    }

    public static PurchasedLottos createLotto(LottoPrice lottoPrice) {
        List<Lotto> lottos = new ArrayList<>();
        lottoPrice.create(() -> {
            Collections.shuffle(LottoMachine.lottoNumbers);
            lottos.add(new Lotto(new HashSet<>(LottoMachine.lottoNumbers.subList(0, 6))));
        });
        return new PurchasedLottos(lottos);
    }
}
