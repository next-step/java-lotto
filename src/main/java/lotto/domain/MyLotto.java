package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {
    private static int LOTTO_PRICE = 1000;
    private List<Lotto> lottoList = new ArrayList<>();

    public MyLotto(int money){
        for(int i=0; i<money/LOTTO_PRICE; i++){
            lottoList.add(new Lotto());
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public PrizeResult getResult(List<Integer> winningNumbers){
        PrizeResult prizeResult = new PrizeResult();
        for(Lotto lotto : lottoList){
            prizeResult.addPrizeResult(matchResult(winningNumbers, lotto));
        }

        return prizeResult;
    }

    private MatchInfo matchResult(List<Integer> winningNumbers, Lotto lotto){
        return MatchInfo.checkMatch(lotto.getMatchCount(winningNumbers));
    }
}
