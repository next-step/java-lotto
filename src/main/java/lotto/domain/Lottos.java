package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(int numberOfLotto, LottoCreatingStrategy lottoCreatingStrategy) {
        this.lottos = create(numberOfLotto, lottoCreatingStrategy);
    }

    private List<Lotto> create(int numberOfLotto, LottoCreatingStrategy lottoCreatingStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfLotto; i++ ){
            lottos.add(lottoCreatingStrategy.create());
        }
        return lottos;
    }

    @Override
    public String toString() {
        return String.valueOf(lottos.size());
    }
}
