package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Reward matchPrizeNumber(PrizeLotto prizeLotto) {
        List<PrizeInformation> prizeInformations = lottos.stream()
                .map(lotto -> lotto.getPrize(prizeLotto))
                .collect(Collectors.toList());
        return new Reward(prizeInformations);
    }

    public int quantity() {
        return lottos.size();
    }

    public Set<LottoNumber> getLotto(int index) {
        return lottos.get(index).getLottoNumbers();
    }

}