package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyLottos {

    private List<Lotto> myLottos;
    private MatchResult matchResult;

    MyLottos(List<Lotto> lottos){
        myLottos = new ArrayList<>();
        myLottos.addAll(lottos);
        matchResult = new MatchResult();
    }

    public Map<Integer, Integer> myMatchResult(List<Integer> winningNumbers){
        return matchResult.addMatchResult(myLottos, winningNumbers);
    }

}
