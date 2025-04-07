package Lotto.domain;

import java.util.*;

import static Lotto.domain.Lotto.generateLottoNumbers;

public class Lottos {
    public static final int LOTTO_PICK_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final List<Lotto> lottos;
    private final int purchasedQty;

    public Lottos(int purchasedQty) {
        this.purchasedQty = purchasedQty;
        this.lottos = generateLottos();
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchasedQty; i++) {
            List<LottoNumber> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
