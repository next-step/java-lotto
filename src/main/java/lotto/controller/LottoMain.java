package lotto.controller;

import lotto.domain.*;
import lotto.strategy.LottoGenerator;
import lotto.strategy.LottoGenerators;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.StringParser;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constant.LOTTO_PRICE;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = validatePrice(inputView);
        int manualLottoCount = inputView.inputManualLottoCount();
        validateLottoPurchaseAmount(manualLottoCount, price);

        inputView.inputManualLottoInform();
        List<String> stringFormatManualLottos = inputStringFormatManualLottos(manualLottoCount, inputView);

        OutputView outputView = new OutputView();
        int autoLottoCount = autoLottoCount(price, manualLottoCount);
        Lottos lottos = generateLottosAndPrint(stringFormatManualLottos, outputView, manualLottoCount, autoLottoCount);

        LottoResult lottoResult = calculateLottoResult(inputView, lottos);

        calculateLottoStatisticsAndPrint(outputView, lottoResult);

        printLottoRate(outputView, price, lottoResult);
    }

    private static int validatePrice(InputView inputView) {
        int price = inputView.inputPrice();
        InputValidator.validatePurchasePrice(price);
        return price;
    }

    private static void validateLottoPurchaseAmount(int manualLottoCount, int price) {
        InputValidator.validateLottoPurchaseAmount(manualLottoCount, price);
    }

    private static List<String> inputStringFormatManualLottos(int manualLottoCount, InputView inputView) {
        List<String> stringFormatManualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            stringFormatManualLottos.add(inputView.inputManualLotto());
        }
        return stringFormatManualLottos;
    }

    private static int autoLottoCount(int price, int manualLottoCount) {
        return (price / LOTTO_PRICE) - manualLottoCount;
    }

    private static Lottos generateLottosAndPrint(List<String> stringFormatManualLottos, OutputView outputView, int manualLottoCount, int autoLottoCount) {
        LottoGenerators lottoGenerators = new LottoGenerators(stringFormatManualLottos, autoLottoCount);
        Lottos lottos = lottoGenerators.generateLottos();
        outputView.printLottos(manualLottoCount, autoLottoCount, lottos);
        return lottos;
    }

    private static LottoResult calculateLottoResult(InputView inputView, Lottos lottos) {
        List<Integer> winningLottoNumbers = StringParser.parseToInts(inputView.inputWinningNumber());
        InputValidator.validateNumberCount(winningLottoNumbers.size());
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
