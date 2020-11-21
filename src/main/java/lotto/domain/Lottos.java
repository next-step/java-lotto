package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Reward matchPrizeNumber(PrizeLotto prizeLotto) {
        List<PrizeInformation> prizeInformations = new ArrayList<>();
        lottos.forEach(lotto ->  prizeInformations.add(lotto.matchPrizeNumber(prizeLotto)));

        return new Reward(prizeInformations);
    }

    public int quantity() {
        return lottos.size();
    }

    public Set<Integer> getLottoNumber(int index) {
        return lottos.get(index).getLottoPickNumber();
    }

}