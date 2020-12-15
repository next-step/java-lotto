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
        int lottoAmount = this.pickLotto();
        this.win(lottoAmount);
    }

    /**
     * 구매한 갯수 만큼 로또 번호들을 뽑습니다.
     */
    private int pickLotto(){
        int payToSum = this.inputView.insertPayToSum();
        this.resultView.printNumberOfPurchasedLotto(payToSum);

        for (int i = 0; i < payToSum; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            List<Integer> pickedLottoNumbers = lottoNumbers.pickLottoNumber();
            this.lottoWinCalculator.addPickedLottoNumbers(pickedLottoNumbers);
            this.resultView.printLottoNumbers(pickedLottoNumbers);
        }
        return payToSum;
    }

    /**
     * 당첨번호를 입력하고 결과를 계산하여 출력합니다.
     */
    private void win(int lottoAmount) {
        // 당첨 번호 입력
        this.lottoWinCalculator.setWinLottoNumbers(
                new LottoNumbers(this.inputView.insertWinLottoNumbers()));

        // 당첨 케이스별 계산 및 출력
        List<LottoWinPrize> lottoWinPrizes = this.lottoWinCalculator.findLottoWinPrize();
        this.resultView.printWinStatistics(lottoWinPrizes);

        // 수익률 출력
        this.resultView.printPriceEarningRatio(
                this.lottoWinCalculator.calculatePriceEarningRatio(lottoWinPrizes, lottoAmount));
    }
}
