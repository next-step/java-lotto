package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.StringParser;

import java.util.List;

import static lotto.constant.Constant.PRICE_UNIT;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int price = inputView.inputPrice();
        InputValidator inputValidator = new InputValidator();
        inputValidator.validatePurchasePrice(price);

        int lottoCount = price / PRICE_UNIT;
        LottoFactory lottoFactory = new LottoFactory();
        Lottos lottos = lottoFactory.generateLottos(lottoCount);

        OutputView outputView = new OutputView();
        outputView.printLottos(lottoCount, lottos);

        StringParser stringParser = new StringParser();
        List<Integer> winningLottoNumbers = stringParser.parseToInts(inputView.inputWinningNumber());

        LottoStatistics lottoStatistics = new LottoStatistics();
        List<LottoWinResult> lottoWinResults = lottoStatistics.statistics(lottos.winCounts(winningLottoNumbers));
        outputView.printLottoResultInfo();
        outputView.printLottoResult(lottoWinResults);

        LottoWinPercentage lottoWinPercentage = lottoStatistics.rate(price, lottoWinResults);
        outputView.printLottoRate(lottoWinPercentage);
    }
}
