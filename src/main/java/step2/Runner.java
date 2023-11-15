package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.math.BigDecimal;
import java.util.List;

import static step2.util.BigDecimalUtil.stringToBigDecimal;
import static step2.util.StringUtil.numbers;

public class Runner {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        BigDecimal price = stringToBigDecimal(inputView.price());
        int manualCount = inputView.manual();
        Lottos lottos = lottos(price);
        resultView.printPurchaseMessage(lottos.size());
        resultView.printLottos(lottos);

        WinningStatistics winningStatistics = winningStatistics(lottos, inputView.prizeLottoNumber(), inputView.bonusNumber());
        resultView.printWinningStatistics(winningStatistics);
        resultView.printRateOfReturn(price, winningStatistics);
    }

    private static Lottos lottos(BigDecimal price) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoStore lottoStore = new LottoStore();

        List<LottoNumbers> lottoNumbers = lottoNumberGenerator.lottoNumbers(lottoStore.numberOfLotto(price));
        return lottoStore.lottos(lottoNumbers);
    }

    private static WinningStatistics winningStatistics(Lottos lottos, String prizeLottoNumberText, int bonusNumber) {
        LottoNumbers prizeLottoNumbers = new LottoNumbers(numbers(prizeLottoNumberText));
        PrizeLotto prizeLotto = new PrizeLotto(prizeLottoNumbers, bonusNumber);

        return WinningStatistics.of(lottos, prizeLotto);
    }

}
