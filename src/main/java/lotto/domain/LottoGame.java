package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public List<List<Integer>> lottoGame(int lottoCount, ShuffleStrategy shuffleStrategy) {

        Lotto lotto = new Lotto();

        List<Integer> lottos = lotto.getLotto();

        List<List<Integer>> buyLottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> buyLotto = shuffleStrategy.shufflable(lottos);
            buyLottoList.add(buyLotto);
        }

        return buyLottoList;
    }
}
