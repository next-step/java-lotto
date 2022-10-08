package lotto.app;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManger;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.strategy.ShuffleExtractStrategy;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int amount = LottoInputView.getAmount();
        int num = LottoSeller.sellLotto(amount);
        LottoResultView.printBuyLottoNumber(num);

        LottoManger lottoManger = new LottoManger(num, new ShuffleExtractStrategy());
        List<Lotto> lottos = lottoManger.retrieveLottos();
        LottoResultView.printLottoNumber(lottos);

        List<Integer> correctNumbers = lottoManger.retrieveWinNums(LottoInputView.getWinNumbers());
        LottoResult lottoResult = new LottoResult(correctNumbers);
        LottoResultView.printWinStatistics(lottoResult.getLottoRankRecords());

        LottoResultView.printProfitRatio(lottoResult.retrieveProfitRatio(amount));
    }
}
