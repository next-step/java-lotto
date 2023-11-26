package lotto;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoList lottoList = generateLottoList();
        LottoWinningNumbers lottoWinningNumbers = generateLottoWinningNumbers();

        LottoGame lottoGame = new LottoGame(lottoList, lottoWinningNumbers);
        LottoResult lottoResult = lottoGame.start();

        printResult(lottoResult);
    }

    public static LottoList generateLottoList() {
        int inputPurchaseAmount = InputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
        List<String> manualLotto = InputView.inputManualLotto();
        int automaticLottoCount = purchaseAmount.automaticLottoCount(manualLotto.size());
        LottoList lottoList = new LottoList(automaticLottoCount, manualLotto);
        OutputView.printLottoList(lottoList, manualLotto.size());

        return lottoList;
    }

    public static LottoWinningNumbers generateLottoWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        String bonusNumber = InputView.inputBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
                new Lotto(winningNumbers), new LottoNumber(bonusNumber)
        );

        return lottoWinningNumbers;
    }

    public static void printResult(LottoResult lottoResult) {
        OutputView.printResult(lottoResult);
    }
}
