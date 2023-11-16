package step2;

import step2.domain.*;
import step2.domain.dto.LottoRequest;
import step2.view.InputView;
import step2.view.ResultView;

import static step2.util.StringUtil.numbers;

public class Runner {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private static final LottoStore lottoStore = new LottoStore(lottoNumberGenerator);

    public static void main(String[] args) {
        LottoRequest request = new LottoRequest(inputView.price(), inputView.manual());
        Lottos lottos = lottoStore.lottos(request);
        resultView.printPurchaseMessage(request);
        resultView.printLottos(lottos);

        WinningStatistics winningStatistics = winningStatistics(lottos, inputView.prizeLottoNumber(), inputView.bonusNumber());
        resultView.printWinningStatistics(winningStatistics);
        resultView.printRateOfReturn(request.price(), winningStatistics);
    }

    private static WinningStatistics winningStatistics(Lottos lottos, String prizeLottoNumberText, int bonusNumber) {
        PrizeLotto prizeLotto = prizeLotto(prizeLottoNumberText, bonusNumber);
        return WinningStatistics.of(lottos, prizeLotto);
    }

    private static PrizeLotto prizeLotto(String prizeLottoNumberText, int bonusNumber) {
        LottoNumbers prizeLottoNumbers = new LottoNumbers(numbers(prizeLottoNumberText));
        return new PrizeLotto(prizeLottoNumbers, bonusNumber);
    }

}
