package lotto.domain.lotto;

import lotto.domain.lotto.creator.LottoCreator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> lottos;

    public LottoMachine(int quantity, LottoCreator lottoCreator) {
        this.lottos = createLottos(lottoCreator, quantity);
    }

    private List<Lotto> createLottos(LottoCreator lottoCreator, int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(lottoCreator.createLotto());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
