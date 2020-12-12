package step4.VO;

import step4.LottoGenerator;
import step4.ResultNumber;
import step4.Statistic;
import step4.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public int getAutoLottoCnt(Money money) {
        return money.getLottoCnt()-lottoList.size();
    }

    public void checkResult(Statistic statistic, ResultNumber resultNumber) {
        for (Lotto lotto: this.lottoList) {
            lotto.checkReward(statistic, resultNumber);
        }
    }

    public void inputLotto(Lotto lotto){
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottosCnt(){
        return lottoList.size();
    }
}
