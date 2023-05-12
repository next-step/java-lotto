package lotto;

import static lotto.view.LottoView.enterBonusNumber;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;
import lotto.view.LottoView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(LottoView.enterPurchaseAmount());
        Lottos lottos = lottoGenerator.generate();
        LottoView.outputPurchaseNumber(lottos.size());
        LottoView.outputLottos(lottos);

        LottoRanks lottoRanks = lottos.drawLots(LottoView.enterWinningNumber(), enterBonusNumber());
        LottoView.outputLottoStatistics(lottoRanks.createStatistics());
        LottoView.outputRate(lottoRanks.createRate());
    }

}
