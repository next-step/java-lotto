package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Reward matchPrizeNumber(PrizeLotto prizeLotto) {
        List<PrizeInformation> prizeInformations = lottos.stream()
                .map(lotto -> lotto.matchPrizeNumber(prizeLotto))
                .collect(Collectors.toList());
        return new Reward(prizeInformations);
    }

    public int quantity() {
        return lottos.size();
    }

    public LottoNumbers getLotto(int index) {
        return lottos.get(index).getLottoPickNumber();
    }

}