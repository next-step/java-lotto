package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMatch {

    private List<Integer> rankOfLotto = new ArrayList<>(Arrays.asList(0,0,0,0));
    private static final int FIRSTPLACE = 0;
    private static final int SECONDPLACE = 1;
    private static final int THIRDPLACE = 2;
    private static final int FOURTHPLACE = 3;


    public void checkRank(BuyLottos buyLottos, Lotto winLotto){
        for(Lotto lotto: buyLottos.getLottos()){
            int result = lotto.numMatch(winLotto);
            checkEachRank(result);
        }
    }

    private void checkEachRank(int input){
        if(input == 3){
            this.rankOfLotto.set(FOURTHPLACE, this.rankOfLotto.get(FOURTHPLACE) + 1);
        }
        if(input == 4){
            this.rankOfLotto.set(THIRDPLACE, this.rankOfLotto.get(THIRDPLACE) + 1);
        }
        if(input == 5){
            this.rankOfLotto.set(SECONDPLACE, this.rankOfLotto.get(SECONDPLACE) + 1);
        }
        if(input == 6){
            this.rankOfLotto.set(FIRSTPLACE, this.rankOfLotto.get(FIRSTPLACE) + 1);
        }
    }

    public List<Integer> getRankOfLotto() {
        return rankOfLotto;
    }
}
