package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.StringParser;

import java.util.List;

import static lotto.constant.Constant.LOTTO_PRICE;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = validatePrice(inputView);
        int manualLottoCount = validateLottoPurchaseAmount(price, inputView);

        OutputView outputView = new OutputView();
        int lottoCount = price / LOTTO_PRICE;
        Lottos lottos = generateLottosAndPrint(outputView, lottoCount);

        LottoResult lottoResult = calculateLottoResult(inputView, lottos);

        calculateLottoStatisticsAndPrint(outputView, lottoResult);

        printLottoRate(outputView, price, lottoResult);
    }

    private static int validatePrice(InputView inputView) {
        int price = inputView.inputPrice();
        InputValidator.validatePurchasePrice(price);
        return price;
    }

    private static int validateLottoPurchaseAmount(int price, InputView inputView) {
        int manualLottoCount = inputView.inputManualLottoCount();
        InputValidator.validateLottoPurchaseAmount(manualLottoCount, price);
        return price;
    }

    private static Lottos generateLottosAndPrint(OutputView outputView, int lottoCount) {
        Lottos lottos = LottoFactory.generateLottos(lottoCount);
        outputView.printLottos(lottoCount, lottos);
        return lottos;
    }

    private static LottoResult calculateLottoResult(InputView inputView, Lottos lottos) {
        List<Integer> winningLottoNumbers = StringParser.parseToInts(inputView.inputWinningNumber());
        BonusBall bonusBall = new BonusBall(inputView.inputBonusBall());
        return new LottoResult(lottos, new LottoWin(new LottoWinNumbers(winningLottoNumbers), bonusBall));
    }

    private static void calculateLottoStatisticsAndPrint(OutputView outputView, LottoResult lottoResult) {
        outputView.printLottoResultInfo();
        outputView.printLottoResult(lottoResult);
    }

    private static void printLottoRate(OutputView outputView, int print, LottoResult lottoResult) {
        LottoWinPercentage lottoWinPercentage = new LottoWinPercentage(print, lottoResult);
        outputView.printLottoRate(lottoWinPercentage);
    }

}
