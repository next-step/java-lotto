package Lotto.domain;

import java.util.*;

import static Lotto.domain.Lotto.generateLottoNumbers;

public class Lottos {
    public static final int LOTTO_PICK_COUNT = 6;

    private final List<Lotto> lottos;

    public Lottos(int purchasedQty) {
        this.lottos = generateLottos(purchasedQty);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    private List<Lotto> generateLottos(int purchasedQty) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchasedQty; i++) {
            List<LottoNumber> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
