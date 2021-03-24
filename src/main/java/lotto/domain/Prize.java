package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Prize {
    Lottos lottos;
    Lotto lotto;
    Map<Rank, Integer> prize;


    public Prize(Lottos lottos, Lotto lotto) {
        this.lottos = lottos;
        this.lotto = lotto;
        this.prize = generatorState();
        getWinningResult();
    }

    private Map<Rank, Integer> generatorState(){
        Map<Rank, Integer> prize = new HashMap<>();
        for(Rank tempPrize : Rank.values()){
            prize.put(tempPrize,0);
        }
        return prize;
    }

    private void getWinningResult() {
        for (Lotto paylotto : lottos.getLottos()) {
            int prizeNum = paylotto.countNumbers(lotto);
            countResult(prizeNum);
        }
    }

    private void countResult(int prizeNum) {
        prize.put(Rank.converterPrize(prizeNum), prize.get(Rank.converterPrize(prizeNum)) + 1);
    }

    public Map<Rank, Integer> getPrize() {
        return prize;
    }
}
