package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottos;

    public LottoWallet() {
        this(new ArrayList<>());
    }

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void generateLotto(int generateLottoCount) {
        for (int i = 0; i < generateLottoCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
