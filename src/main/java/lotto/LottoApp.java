package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApp {
    private static final int MIN_COUNT_OF_REQUIRED_TO_BE_MANUAL_LOTTO_INPUT = 1;

    private final InputView inputView;
    private final ResultView resultView;

    private LottoApp() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public static void main(String[] args) {
        LottoApp lottoApp = new LottoApp();
        int purchasePrice = lottoApp.printPurchasePriceInputMessageAndInput();
        int manualLottoCount = lottoApp.printManualLottoCountInputMessageAndInput();
        if (manualLottoCount >= MIN_COUNT_OF_REQUIRED_TO_BE_MANUAL_LOTTO_INPUT) {
            lottoApp.printManualLottosInputMessage();
        }

        Lottos lottos = lottoApp.createLottos(purchasePrice, manualLottoCount);
        lottoApp.printLottosAndCount(lottos, manualLottoCount);

        Lotto winningNumbers = new Lotto(lottoApp.printWinningNumbersInputMessageAndInput());
        LottoNumber bonusNumber = LottoNumber.valueOf(lottoApp.printBonusNumberInputMessageAndInput());

        List<WinningRank> winningRanks = WinningRank.findWinningRanks(lottos, new DrawNumbers(winningNumbers, bonusNumber));
        lottoApp.printWinningStatistics(purchasePrice, winningRanks);
    }

    private int printPurchasePriceInputMessageAndInput() {
        inputView.printPurchasePriceInputMessage();
        int purchasePrice = inputView.inputPurchasePrice();

        inputView.executeNextLine();
        inputView.printNewLine();
        return purchasePrice;
    }

    private int printManualLottoCountInputMessageAndInput() {
        inputView.printManualLottoCountInputMessage();
        int manualLottoCount = inputView.inputManualLottoCount();

        inputView.printNewLine();
        return manualLottoCount;
    }

    private void printManualLottosInputMessage() {
        inputView.printManualLottosInputMessage();
    }

    private Lottos createLottos(int purchaseAmount, int manualLottoCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(inputManualLottoNumbers()));
        }
        return new Lottos(purchaseAmount, manualLottos);
    }

    private List<Integer> inputManualLottoNumbers() {
        return inputView.inputManualLotto();
    }

    private void printLottosAndCount(Lottos lottos, int manualLottoCount) {
        resultView.printLottoCount(lottos.getSize(), manualLottoCount);
        resultView.printLottos(lottos);
    }

    private List<Integer> printWinningNumbersInputMessageAndInput() {
        inputView.printWinningNumbersInputMessage();
        return inputView.inputWinningNumbers();
    }

    private Integer printBonusNumberInputMessageAndInput() {
        inputView.printBonusNumberInputMessage();
        return inputView.inputBonusNumber();
    }

    private void printWinningStatistics(int purchaseAmount, List<WinningRank> winningRanks) {
        resultView.printNewLine();
        resultView.printWinningStatistics(purchaseAmount, winningRanks);
    }
}
