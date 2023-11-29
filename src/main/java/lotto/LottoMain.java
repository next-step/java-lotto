package lotto;


import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningNumbers;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        Lotto lotto = sellLotto(lottoInputView);
        LottoResultView.printLotto(lotto);

        WinningNumbers winningNumbers = inputWinningNubmers(lottoInputView);
        LottoResultView.printResult(new LottoResult(lotto.makeStatistics(winningNumbers), lotto.calcRateOfReturn(winningNumbers)));
    }

    private static WinningNumbers inputWinningNubmers(LottoInputView lottoInputView) {
        WinningNumbers winningNumbers;
        while (true) {
            try {
                winningNumbers = new WinningNumbers(new LottoNumbers(lottoInputView.inputWinningNumbers()), new LottoNumber(lottoInputView.inputBonusNumber()));
                break;
            } catch (IllegalArgumentException e) {
                LottoResultView.printExceptionMsg(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private static Lotto sellLotto(LottoInputView lottoInputView) {
        Lotto lotto;
        while (true) {
            try {
                lotto = Lotto.sellLotto(lottoInputView.inputBuyingMoney(), lottoInputView.inputManualNumbers(lottoInputView.inputManualCount()));
                break;
            } catch (IllegalArgumentException e) {
                LottoResultView.printExceptionMsg(e.getMessage());
            }
        }
        return lotto;
    }
}
