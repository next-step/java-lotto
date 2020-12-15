package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinPrize;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoRunner {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        Lottos lottos = this.makeLottos();
        this.win(lottos);
    }

    /**
     * 구매한 갯수 만큼 로또 번호들을 뽑습니다.
     */
    private Lottos makeLottos(){
        Lottos lottos = new Lottos();
        int lottoCount = this.inputView.getLottoCount();
        this.resultView.printNumberOfPurchasedLotto(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            this.resultView.printLottoNumbers(lotto);
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    /**
     * 당첨번호를 입력하고 결과를 계산하여 출력합니다.
     * @param lottos
     */
    private void win(Lottos lottos) {
        LottoWinCalculator lottoWinCalculator
                = new LottoWinCalculator(new Lotto(this.inputView.insertWinLottoNumbers()));

        // 당첨 케이스별 계산 및 출력
        List<LottoWinPrize> lottoWinPrizes = lottoWinCalculator.findLottoWinPrize(lottos);
        this.resultView.printWinStatistics(lottoWinPrizes);

        // 수익률 출력
        this.resultView.printPriceEarningRatio(
                lottoWinCalculator.calculatePriceEarningRatio(lottoWinPrizes, lottos.size()));
    }
}
