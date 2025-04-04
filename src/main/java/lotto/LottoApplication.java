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

        int price = inputView.getPurchasePrice();
        LottoShop lottoShop = new LottoShop(price, new LottoAutoGenerator());
        resultView.printLottoTicketAmount(lottoShop.getTicketAmount());
        lottoShop.getLottoTicketsNumber().forEach(resultView::printLottoNumbers);

        List<LottoNumber> winningNumbers = parser.splitAndParseToLottoNumberList(inputView.getWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(inputView.getBonusNumber());
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        LottoEarning lottoEarning = LottoEarning.from(winningLottoNumbers.calculateResult(lottoShop.getLottoTicketsNumber()), lottoShop.getPurchasePrice());
        resultView.printMatchResult(lottoEarning.getResult());
        resultView.printReturnRate(lottoEarning.getReturnRate());
    }
}
