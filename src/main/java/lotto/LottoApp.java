package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.RandomLottoNumbersGenerator;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoApp {

    public static void main(String[] args) {
        int buyAmount = InputView.scanBuyAmount();
        int lottoCount = Lotto.convertLottoCount(buyAmount);

        int manualLottoCount = InputView.scanManualLottoCount();
        List<Lotto> manualLottos = InputView.scanManualLottos(manualLottoCount);

        LottoGenerator lottoGenerator = new LottoGenerator(new RandomLottoNumbersGenerator());
        List<Lotto> autoLottos = lottoGenerator.generate(lottoCount - manualLottoCount);

        Lotto winnerLotto = InputView.scanWinningNumbers();
        LottoNumber bonusNumber = InputView.scanBonusRepeat(winnerLotto);

        List<Lotto> allLottos = LottoCollection.concatLottos(manualLottos, autoLottos);
        LottoCollection lottoCollection = new LottoCollection(allLottos);
        LottoResult lottoResult = lottoCollection.getLottoResult(winnerLotto, bonusNumber, buyAmount);

        ResultView.printLottoNumberList(lottoCollection);
        ResultView.printStatistics(lottoResult);
    }

}
