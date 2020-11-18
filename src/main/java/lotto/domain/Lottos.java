package lotto.domain;

import lotto.domain.exception.NotMatchLottoNumberException;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;
    private Reward reward;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void matchPrizeNumber(List<Integer> prizeNumber) {
        lottos.forEach(lotto -> lotto.matchPrizeNumber(prizeNumber));
        createReward();
    }

    private void createReward() {
        List<PrizeInformation> prizeInformations = new ArrayList<>();
        for (int i = 0; i < lottos.size(); i++) {
            prizeInformations.add(lottos.get(i).getPrizeInformation());
        }
        reward = new Reward(prizeInformations);
    }

    public int hasLottoSize() {
        return lottos.size();
    }

    public List<Integer> getLottoNumber(int index) {
        return lottos.get(index).getLottoPickNumber();
    }

    public Reward getReward(){
        if(reward == null){
            throw new NotMatchLottoNumberException();
        }
        return reward;
    }


}
