package lotto.application;

import lotto.domain.Lottos;
import lotto.domain.NumberGeneration;

import java.util.List;

public class LottoGeneration {
    private final Lottos lottos;

    public LottoGeneration(int count, NumberGeneration numberGeneration) {
        this.lottos = new Lottos(count, numberGeneration);
    }

    public int countLottoBundle() {
        return lottos.size();
    }

    public List<String> findLottoBundleForPrint(){return lottos.find();};
}
