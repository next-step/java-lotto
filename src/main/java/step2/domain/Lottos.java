package step2.domain;

import step2.domain.starategy.GetLottoNumberStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Integer purchaseAmount, GetLottoNumberStrategy getLottoNumberStrategy) {
        int purchaseCount = purchaseAmount/1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(getLottoNumberStrategy);
            lottos.add(lotto);
        }
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Integer> checkMatching(List<Integer> winningNumbers) {
        List<Integer> matchingList = new ArrayList<>();
        for (int i = 0; i < Lotto.SIZE+1; i++) {
            matchingList.add(0);
        }
        lottos.stream()
                .forEach(i -> matchingList.set(i.checkMatching(winningNumbers),matchingList.get(i.checkMatching(winningNumbers))+1));
        return matchingList;
    }
}
