package step3.VO;

import step3.LottoGenerator;
import step3.VO.Lotto;
import step3.VO.Money;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public Lottos(Money money, LottoGenerator lottoGenerator) {
        for (int i = 1; i <= money.getLottoCnt(); i++) {
            buyLotto(lottoGenerator);
        }
    }

    public void checkResult() {
        for (Lotto lotto: this.lottoList) {
            lotto.checkReward();
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
