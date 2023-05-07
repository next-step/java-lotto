package lotto.domain;

import java.util.List;
import lotto.view.LottoView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(LottoView.enterPurchaseAmount());
        List<Lotto> lottos = lottoGenerator.generate();
        LottoView.outputLottos(lottos);

        LottoAnnounce lottoAnnounce = new LottoAnnounce(LottoView.enterWinningNumber());
        LottoRanks lottoRanks = lottoAnnounce.createRanks(lottos);
        LottoView.outputLottoStatistics(lottoRanks.createStatistics());
        LottoView.outputRate(lottoRanks.createRate());
    }

}
