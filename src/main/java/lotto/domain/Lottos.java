package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(LottoPrice lottoPrice) {
        this.lottos = generatorLottos(lottoPrice.getLottoCount());
    }

    private List<Lotto> generatorLottos(int lottoCount) {
        List<Lotto> lottoLists = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoLists.add(LottoNumberGenerator.generate());
        }

        return lottoLists;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
