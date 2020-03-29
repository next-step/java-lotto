package lotto;

import lotto.domain.Buyer;
import lotto.domain.BuyerResult;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPrice();

        Buyer buyer = new Buyer();
        List<LottoTicket> lottoTickets = buyer.buyLottoTickets(inputView.getPrice());

        ResultView resultView = new ResultView();
        resultView.printLottoTickets(lottoTickets);

        inputView.inputWinningNumbers();

        int[] winningNumbers = inputView.getWinningNumbers();
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int winningNumber : winningNumbers) {
            lottoNumbers.add(LottoNumber.of(winningNumber));
        }
        BuyerResult buyerResult = buyer.getResult(new LottoTicket(lottoNumbers));

        resultView.printWinningStatistics(buyerResult);
    }
}
