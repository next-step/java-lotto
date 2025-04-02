package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Parser parser = new Parser();

        int price = inputView.getIntegerInput();
        LottoShop lottoShop = new LottoShop(price, new LottoAutoGenerator());
        resultView.printLottoTicketAmount(lottoShop.getTicketAmount());
        lottoShop.getLottoTicketsNumber().forEach(resultView::printLottoNumbers);

        List<LottoNumber> winningNumbers = parser.splitAndParseToLottoNumberList(inputView.getStringInput());
        LottoResult lottoResult = LottoResult.from(winningNumbers, lottoShop.getLottoTicketsNumber());
        resultView.printMatchResult(lottoResult.getResult());
        LottoEarning lottoProfit = LottoEarning.from(lottoResult.getResult(), lottoShop.getPurchasePrice());
        resultView.printReturnRate(lottoProfit.getReturnRate());
    }
}
