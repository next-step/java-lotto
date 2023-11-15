package lotto.domain;

import java.util.*;

public class LottoGame {

    public List<List<Integer>> lottoGame(int lottoCount, ShuffleStrategy shuffleStrategy) {

        Lotto lotto = new Lotto();

        List<Integer> lottoList = lotto.getLotto();

        List<List<Integer>> buyLottoList = new ArrayList<>();

        List<Integer> buyLotto;

        for(int i=0; i<lottoCount; i++){
            buyLotto = shuffleStrategy.shufflable(lottoList);
            buyLottoList.add(buyLotto);
        }

        return buyLottoList;
    }
}
