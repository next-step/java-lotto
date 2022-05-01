package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final LottoNumbers fullLottoNumbers;

    public LottoStore() {
        this.fullLottoNumbers = LottoNumbers.fullLottoNumbers();
    }

    public Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(fullLottoNumbers.randomLottoNumbers()));
        }
        return new Lottos(lottos);
    }
}
