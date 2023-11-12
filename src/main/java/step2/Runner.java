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
        LottoStore lottoStore = new LottoStore();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        BigDecimal price = stringToBigDecimal(inputView.price());
        int numberOfLotto = lottoStore.numberOfLotto(price);
        resultView.printPurchaseMessage(numberOfLotto);

        List<LottoNumbers> lottoNumbers = lottoNumberGenerator.lottoNumbers(numberOfLotto);
        Lottos lottos = lottoStore.lottos(lottoNumbers);
        resultView.printLottos(lottos);

        LottoNumbers prizeLottoNumbers = new LottoNumbers(numbers(inputView.prizeLottoNumber()));
        int bonusNumber = inputView.bonusNumber();
        PrizeLotto prizeLotto = new PrizeLotto(prizeLottoNumbers, bonusNumber);
        WinningStatistics winningStatistics = WinningStatistics.of(lottos, prizeLotto);
        resultView.printWinningStatistics(winningStatistics);
        resultView.printRateOfReturn(price, winningStatistics);
    }

}
