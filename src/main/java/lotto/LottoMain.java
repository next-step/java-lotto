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

        Lotto lotto = new Lotto();
        int buyingMoney = lottoInputView.inputBuyingMoney();
        int manualCount = lottoInputView.inputManualCount();

        lotto.sellLotto(buyingMoney, lottoInputView.inputManualNumbers(manualCount));
        LottoResultView.printBuyingStatus(manualCount, lotto.lottoNumbersCount() - manualCount);
        LottoResultView.printLotto(lotto);

        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(lottoInputView.inputWinningNumbers()), new LottoNumber(lottoInputView.inputBonusNumber()));
        LottoResult lottoResult = new LottoResult(lotto.makeStatistics(winningNumbers), lotto.calcRateOfReturn(winningNumbers));

        LottoResultView.printResult(lottoResult);
    }
}
