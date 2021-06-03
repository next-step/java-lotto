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
        int manualBuyLottoCount = inputView.inputManualLottoBuyCount(inputMoney);
        int autoBuyLottoCount = getAutoBuyLottoCount(inputMoney, manualBuyLottoCount);

        LottoNumbersList lottoNumbersList = generateBuyingLottoNumbers(manualBuyLottoCount, autoBuyLottoCount);
        WinningLottoNumbers winningLottoNumbers = generateWinningLottoNumbers();

        ResultAllLottoScores resultAllLottoScores = new ResultAllLottoScores();
        for (int i=0; i<lottoNumbersList.count(); i++)
            resultAllLottoScores.updateResult(winningLottoNumbers.matchLottoNumbers((lottoNumbersList.lottoNumberList(i))));
        resultView.printLottoGameResult(resultAllLottoScores, inputMoney);
    }

    public WinningLottoNumbers generateWinningLottoNumbers() {
        String inputWinningLottoNumbers =  inputView.inputWinningLottoNumbers();
        String inputBonusLottoNumber = inputView.inputBonusLottoNumber();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputWinningLottoNumbers, inputBonusLottoNumber);
        return winningLottoNumbers;
    }

    public LottoNumbersList generateBuyingLottoNumbers(int manualBuyLottoCount, int autoBuyLottoCount) {
        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        if (manualBuyLottoCount > 0)
            lottoNumbersList = generateManualLottoNumbersList(lottoNumbersList, manualBuyLottoCount);

        if (autoBuyLottoCount > 0)
            lottoNumbersList = generateAutoLottoNumbersLit(lottoNumbersList, autoBuyLottoCount);

        resultView.printPurchasedCount(manualBuyLottoCount, autoBuyLottoCount, lottoNumbersList);
        return lottoNumbersList;
    }

    public LottoNumbersList generateManualLottoNumbersList(LottoNumbersList lottoNumbersList, int manualBuyLottoCount) {
        LottoNumbers[] lottoNumbers  = inputView.inputManualLottoNumbers(manualBuyLottoCount);
        for (int i=0; i<lottoNumbers.length; i++)
            lottoNumbersList.appendLottoNumber(lottoNumbers[i]);
        return lottoNumbersList;
    }

    public LottoNumbersList generateAutoLottoNumbersLit(LottoNumbersList lottoNumbersList, int autoBuyLottoCount) {
        for( int i=0; i<autoBuyLottoCount; i++)
            lottoNumbersList.appendLottoNumber(new LottoNumbers(new LottoNumberGenerator()));

        return lottoNumbersList;
    }

    public int getAutoBuyLottoCount(int inputMoney, int manualBuyLottoCount) {
        return (inputMoney - (manualBuyLottoCount * Constant.LOTTO_PRICE.value())) / Constant.LOTTO_PRICE.value();
    }
}
