package step02.controller;

import java.util.List;

import step02.domain.Lotto;
import step02.domain.LottoList;
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
        LottoList lottoList = LottoSeller.sell(purchasePrice);
        PrintView.printLottoPurchaseCountMessage(lottoList.size());

        lottoList.getValue().stream().map(Lotto::getValue).forEach(PrintView::printLottoNumbers);
        PrintView.printBlank();

        List<Integer> lastWeekWinningNumbers = InputView.initLastWeekWinningNumbers();
        PrintView.printBlank();
        Lotto winners = new Lotto(lastWeekWinningNumbers);

        LottoResult lottoResult = LottoResultGenerator.generate(lottoList, winners);
        PrintView.printLottoResult(lottoResult, purchasePrice);
    }
}
