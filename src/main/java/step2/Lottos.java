package step2;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public Lottos(int money, LottoGenerator lottoGenerator) {
        for (int i = 1; i <= getLottoCnt(money); i++) {
            buyLotto(lottoGenerator);
        }
    }
    public void checkResult(List<LottoNumber> result) {
        for (Lotto lotto: this.lottoList) {
            lotto.checkReward(result);
        }
    }

    private void buyLotto(LottoGenerator lottoGenerator){
        lottoList.add(new Lotto(lottoGenerator));
    }

    public int getLottoCnt(int money) {
        return money / 1000;
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottosCnt(){
        return lottoList.size();
    }
}
