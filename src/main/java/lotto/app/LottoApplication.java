package lotto.app;

import java.util.List;
import lotto.domain.LottoBall;
import lotto.domain.LottoInput;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.Lotto;
import lotto.domain.LottoBox;
import lotto.domain.LottoBoxFactory;
import lotto.domain.LottoRankRecordBoxFactory;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.strategy.ShuffleExtractStrategy;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int amount = LottoInputView.getAmount();
        int manualLottoCount = LottoInputView.getManualLottoCount();
        LottoInput lottoInput = LottoSeller.sellLotto(amount, manualLottoCount);

        List<Lotto> manualLottos = LottoInputView.getManualLottos(lottoInput.getManualCount());
        LottoBox lottoBox = LottoBoxFactory.createLottoBox(lottoInput.getAutoCount(), new ShuffleExtractStrategy(), manualLottos);

        LottoResultView.printLottoInput(lottoInput);
        LottoResultView.printLottoNumber(lottoBox.getLottos());

        Lotto winnerLotto = new Lotto(LottoInputView.getWinNumbers());
        LottoBall bonusBall = LottoInputView.getBonusBallNumber();

        List<WinningResult> winningResults = lottoBox.retrieveCorrectNum(WinningLotto.of(winnerLotto, bonusBall));
        LottoResult lottoResult = new LottoResult(LottoRankRecordBoxFactory.createLottoRankRecordBox(winningResults));

        LottoResultView.printWinStatistics(lottoResult.getLottoRankRecords());
        LottoResultView.printProfitRatio(lottoResult.retrieveProfitRatio(amount));
    }
}
