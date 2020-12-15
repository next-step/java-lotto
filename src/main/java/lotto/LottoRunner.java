package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinPrize;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoRunner {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoWinCalculator lottoWinCalculator = new LottoWinCalculator();

    public void run() {
        this.pickLotto();
        this.win();
    }

    /**
     * 구매한 갯수 만큼 로또 번호들을 뽑습니다.
     */
    private void pickLotto(){
        int payToSum = this.inputView.insertPayToSum();
        this.resultView.printNumberOfPurchasedLotto(payToSum);

        for (int i = 0; i < payToSum; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            List<Integer> pickedLottoNumbers = lottoNumbers.pickLottoNumber();
            this.lottoWinCalculator.addPickedLottoNumbers(pickedLottoNumbers);
            this.resultView.printLottoNumbers(pickedLottoNumbers);
        }
    }

    /**
     * 당첨번호를 입력하고 결과를 계산하여 출력합니다.
     */
    private void win() {
        List<Integer> winLottoNumbers = this.inputView.insertWinLottoNumbers();
        this.lottoWinCalculator.setWinLottoNumbers(new LottoNumbers(winLottoNumbers));

        List<Integer> matchedCounts = this.lottoWinCalculator.calculateMatchedCounts();
        List<LottoWinPrize> lottoWinPrizes = this.lottoWinCalculator.findLottoWinPrize(matchedCounts);
        this.resultView.printWinStatistics(lottoWinPrizes);
    }
}
