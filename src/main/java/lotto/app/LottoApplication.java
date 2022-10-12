package lotto.app;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBox;
import lotto.domain.LottoManager;
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

        LottoBox lottoBox = LottoManager.createLottoBox(num, new ShuffleExtractStrategy());
        LottoResultView.printLottoNumber(lottoBox.getLottos());

        List<Integer> correctNumbers = lottoBox.retrieveCorrectNum(new Lotto(LottoInputView.getWinNumbers()));
        LottoResult lottoResult = new LottoResult(correctNumbers);
        LottoResultView.printWinStatistics(lottoResult.getLottoRankRecords());

        LottoResultView.printProfitRatio(lottoResult.retrieveProfitRatio(amount));
    }
}
