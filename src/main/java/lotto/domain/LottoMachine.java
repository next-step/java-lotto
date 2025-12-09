package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoMachine {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private static final List<NumberElement> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
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
