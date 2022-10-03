package step02.controller;

import java.util.List;
import java.util.Map;

import step02.domain.Lotto;
import step02.domain.LottoGrade;
import step02.domain.LottoResult;
import step02.domain.LottoResultGenerator;
import step02.domain.LottoSeller;
import step02.view.InputView;
import step02.view.PrintView;

public class LottoMain {

    private LottoMain() {
    }

    public static void main(String[] args) {
        int purchasePrice = InputView.initPurchasePrice();
        List<Lotto> lottoNumbers = LottoSeller.sell(purchasePrice);
        PrintView.printLottoPurchaseCountMessage(lottoNumbers.size());

        lottoNumbers.stream().map(Lotto::getValue).forEach(PrintView::printLottoNumbers);
        PrintView.printBlank();

        List<Integer> lastWeekWinningNumbers = InputView.initLastWeekWinningNumbers();
        Lotto winners = new Lotto(lastWeekWinningNumbers);

        LottoResult lottoResult = LottoResultGenerator.generate(lottoNumbers, winners);
        Map<LottoGrade, Integer> lottoGradeResultMap = lottoResult.getLottoGradeResultMap();

        PrintView.printResultWinningMessage();
        PrintView.printLottoResultByGrade(LottoGrade.FOURTH, lottoGradeResultMap.getOrDefault(LottoGrade.FOURTH, 0));
        PrintView.printLottoResultByGrade(LottoGrade.THIRD, lottoGradeResultMap.getOrDefault(LottoGrade.THIRD, 0));
        PrintView.printLottoResultByGrade(LottoGrade.SECOND, lottoGradeResultMap.getOrDefault(LottoGrade.SECOND, 0));
        PrintView.printLottoResultByGrade(LottoGrade.FIRST, lottoGradeResultMap.getOrDefault(LottoGrade.FIRST, 0));

        float earningRate = lottoResult.getTotalAmount() / (float) purchasePrice;
        PrintView.printLottoEarningRateResult(earningRate);
    }
}
