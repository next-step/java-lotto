package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final int numberOfLotto;

    public LottoStore(LottoMoney lottoMoney) {
        this.numberOfLotto = lottoMoney.getNumberOfLotto();
    }

    public List<Lotto> sellLotto() {
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(Lotto.getAutoLotto());
        }
        return lottos;
    }

}
