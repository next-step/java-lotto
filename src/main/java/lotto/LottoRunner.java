package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoRunner {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        Lottos lottos = this.makeLottos();
        LottoWinResult lottoWinResult = this.win(lottos);
        this.printResult(lottoWinResult, lottos);
    }

    /**
     * 구매한 갯수 만큼 로또 번호들을 뽑습니다.
     */
    private Lottos makeLottos() {
        int lottoCount = this.inputView.getLottoCount();
        this.resultView.printNumberOfPurchasedLotto(lottoCount);
        Lottos lottos = new Lottos(lottoCount);
        this.resultView.printLottoNumbers(lottos);
        return lottos;
    }

    /**
     * 당첨번호를 입력하고 결과를 계산합니다..
     * @param lottos
     */
    private LottoWinResult win(Lottos lottos) {
        LottoWinCalculator lottoWinCalculator
                = new LottoWinCalculator(new Lotto(this.inputView.insertWinLottoNumbers()));

        return lottoWinCalculator.findLottoWinPrize(lottos);
    }

    /**
     * 당첨 케이스 별 당첨 된 수와 수익률을 출력합니다.
     * @param lottoWinResult
     */
    private void printResult(LottoWinResult lottoWinResult, Lottos lottos) {
        this.resultView.printWinStatistics(lottoWinResult);
        this.resultView.printPriceEarningRatio(lottoWinResult.calculatePriceEarningRatio(lottos.size()));
    }
}
