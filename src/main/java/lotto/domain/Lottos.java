package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Reward matchPrizeNumber(List<Integer> prizeNumber) {
        List<PrizeInformation> prizeInformations = new ArrayList<>();
        lottos.forEach(lotto ->  prizeInformations.add(lotto.matchPrizeNumber(prizeNumber)));

        return new Reward(prizeInformations);
    }

    public int quantity() {
        return lottos.size();
    }

    public List<Integer> getLottoNumber(int index) {
        return lottos.get(index).getLottoPickNumber();
    }

}
