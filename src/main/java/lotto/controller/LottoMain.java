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
        InputValidator.validatePurchasePrice(price);

        int lottoCount = price / PRICE_UNIT;
        Lottos lottos = LottoFactory.generateLottos(lottoCount);

        OutputView outputView = new OutputView();
        outputView.printLottos(lottoCount, lottos);

        List<Integer> winningLottoNumbers = StringParser.parseToInts(inputView.inputWinningNumber());

        LottoStatistics lottoStatistics = new LottoStatistics();
        List<LottoWinResult> lottoWinResults = lottoStatistics.statistics(lottos.winCounts(winningLottoNumbers));
        outputView.printLottoResultInfo();
        outputView.printLottoResult(lottoWinResults);

        LottoWinPercentage lottoWinPercentage = new LottoWinPercentage(price, lottoWinResults);
        outputView.printLottoRate(lottoWinPercentage);
    }
}
