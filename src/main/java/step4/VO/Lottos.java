package step4.VO;

import step4.LottoGenerator;
import step4.ResultNumber;
import step4.Statistic;
import step4.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public void buyAutoLottos(Money money, LottoGenerator lottoGenerator) {
        int autoCnt = getAutoLottoCnt(money);
        for (int i = 1; i <= autoCnt; i++) {
            buyAutoLotto(lottoGenerator);
        }
    }

    private int getAutoLottoCnt(Money money) {
        return money.getLottoCnt()-lottoList.size();
    }

    public void buyManualLottos(List<ManualLottoNumbers> manualLottoNumbersList) {
        for (ManualLottoNumbers manualLottoNumbers: manualLottoNumbersList) {
            lottoList.add(new Lotto(manualLottoNumbers.getManualLottoNumbers()));
        }
    }

    public void checkResult(Statistic statistic, ResultNumber resultNumber) {
        for (Lotto lotto: this.lottoList) {
            lotto.checkReward(statistic, resultNumber);
        }
    }

    private void buyAutoLotto(LottoGenerator lottoGenerator){
        lottoList.add(new Lotto(lottoGenerator.getLottoNumbers()));
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottosCnt(){
        return lottoList.size();
    }
}
