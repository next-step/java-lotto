package lotto.domain;
import lotto.common.Constant;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private InputView inputView;
    private ResultView resultView;

    public LottoGame() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void LottoStart() {
        int inputMoney = inputView.inputMoneyForLotto();
        int manualBuyLottoCount = inputView.inputManualLottoBuyCount();
        int autoBuyLottoCount = getAutoBuyLottoCount(inputMoney, manualBuyLottoCount);
        LottoNumbers[] lottoNumbers  = inputView.inputManualLottoNumbers(manualBuyLottoCount);
        LottoNumbersList lottoNumbersList = new LottoNumbersList(lottoNumbers);
        for( int i=0; i<autoBuyLottoCount; i++)
            lottoNumbersList.appendLottoNumber(new LottoNumbers(new LottoNumberGenerator()));
        resultView.printPurchasedCount(manualBuyLottoCount, autoBuyLottoCount, lottoNumbersList);
        String inputWinningLottoNumbers =  inputView.inputWinningLottoNumbers();
        String inputBonusLottoNumber = inputView.inputBonusLottoNumber();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputWinningLottoNumbers, inputBonusLottoNumber);
        ResultAllLottoScores resultAllLottoScores = new ResultAllLottoScores();
        for (int i=0; i<lottoNumbersList.count(); i++) {
            resultAllLottoScores.updateResult(winningLottoNumbers.matchLottoNumbers(lottoNumbersList.lottoNumberList(i)));
        }
        resultView.printLottoGameResult(resultAllLottoScores, inputMoney);
    }

    public int getAutoBuyLottoCount(int inputMoney, int manualBuyLottoCount) {
        return (inputMoney - (manualBuyLottoCount * Constant.LOTTO_PRICE.value())) / Constant.LOTTO_PRICE.value();
    }

    public int availablePurchaseCount(int amount) {
        return amount / Constant.LOTTO_PRICE.value();
    }
}
