package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

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

    public void addLotto(Lotto lotto) {
        if(lottos == null){
            lottos = new ArrayList<>();
        }
        lottos.add(lotto);
    }

    public void addManualLottos(List<Lotto> manualLottos) {
        lottos.addAll(manualLottos);
    }
}