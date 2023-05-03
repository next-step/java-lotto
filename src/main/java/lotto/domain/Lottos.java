package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(int numberOfLotto, LottoCreatingStrategy lottoCreatingStrategy) {
        this.lottos = createLottos(numberOfLotto, lottoCreatingStrategy);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(int numberOfLotto, LottoCreatingStrategy lottoCreatingStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfLotto; i++ ){
            lottos.add(create(lottoCreatingStrategy));
        }
        return lottos;
    }

    private Lotto create(LottoCreatingStrategy lottoCreatingStrategy) {
        return lottoCreatingStrategy.create();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
