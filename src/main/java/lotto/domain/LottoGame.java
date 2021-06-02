package lotto.domain;

import com.sun.org.apache.regexp.internal.RE;
import lotto.common.Constant;
import lotto.view.InputView;
import lotto.view.InputView_ref;
import lotto.view.ResultView;

public class LottoGame {
    private LastWonLottoNumber_ref lastWonLottoNumberRef;
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
        /*
        resultViewRef.printPurchasedCount(lottoCount);
        LottoNumbersList_ref lottoNumbersListRef = purchaseLottos(lottoCount);
        resultViewRef.printPurchasedLottos(lottoNumbersListRef);
        inputViewRef.inputLastWonLottoNumbers();
        inputViewRef.inputBonusLottoNumber();
        resultViewRef.printLottoGameResult(resultLottoGame(inputViewRef, lottoNumbersListRef), inputViewRef.getInputAmount());

         */
    }

    public int getAutoBuyLottoCount(int inputMoney, int manualBuyLottoCount) {
        return (inputMoney - (manualBuyLottoCount * Constant.LOTTO_PRICE.value())) / Constant.LOTTO_PRICE.value();
    }

    public int availablePurchaseCount(int amount) {
        return amount / Constant.LOTTO_PRICE.value();
    }

    public LottoNumbersList_ref purchaseLottos(int lottoCount) {
        LottoNumbersList_ref lottoNumbersListRef = new LottoNumbersList_ref();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbersListRef.appendLottoNumber(purchaseOneLotto());
        }
        return lottoNumbersListRef;
    }

    public LottoNumbers_ref purchaseOneLotto() {
        LottoNumbers_ref lottoNumbersRef = new LottoNumbers_ref(new LottoNumberGeneratorRef());
        return lottoNumbersRef;
    }

    public ResultAllLottoScores_ref resultLottoGame(InputView_ref inputViewRef, LottoNumbersList_ref lottoNumbersListRef) {
        return lottoNumbersListRef.countMatchedNumbersList(setLastWonLottoNumbers(inputViewRef));
    }

    private LastWonLottoNumber_ref setLastWonLottoNumbers(InputView_ref inputViewRef) {
        lastWonLottoNumberRef = new LastWonLottoNumber_ref(inputViewRef.getInputLastWonLottoNumbers(), inputViewRef.getInputBonusNumber());
        return lastWonLottoNumberRef;
    }
}
