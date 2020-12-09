package step4.VO;

import step4.LottoGenerator;
import step4.ResultNumber;
import step4.Statistic;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public void buyAutoLotto(Money money, LottoGenerator lottoGenerator) {
        for (int i = 1; i <= money.getLottoCnt(); i++) {
            buyLotto(lottoGenerator);
        }
    }

    public void checkResult(Statistic statistic, ResultNumber resultNumber) {
        for (Lotto lotto: this.lottoList) {
            lotto.checkReward(statistic, resultNumber);
        }
    }

    private void buyLotto(LottoGenerator lottoGenerator){
        lottoList.add(new Lotto(lottoGenerator));
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottosCnt(){
        return lottoList.size();
    }
}
