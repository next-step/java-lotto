package lotto.app;

import java.util.List;
import lotto.domain.CorrectInfo;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoBox;
import lotto.domain.LottoManager;
import lotto.domain.LottoRankRecordFactory;
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

        List<CorrectInfo> correctInfos = lottoBox.retrieveCorrectNum(new Lotto(LottoInputView.getWinNumbers()), LottoInputView.getBonusBallNumber());
        LottoResult lottoResult = new LottoResult(LottoRankRecordFactory.createLottoRankRecords(correctInfos));

        LottoResultView.printWinStatistics(lottoResult.getLottoRankRecords());
        LottoResultView.printProfitRatio(lottoResult.retrieveProfitRatio(amount));
    }
}
