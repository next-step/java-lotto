package lotto;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        int totalPrice = InputView.inputTotalPrice();
        ResultView.printTotalCount(totalPrice);
        LottoTickets lottoTickets = LottoTickets.from(totalPrice);
        ResultView.printResultTickets(lottoTickets.createTickets());
        List<LottoNumber> winningNumbers = InputView.inputLottoNumberLastResult();
        ResultView.printWinningNumber(winningNumbers);
        LottoResult result = lottoTickets.result(winningNumbers);
        ResultView.printStatistics(result.result());

        ResultView.printRating(result.result(), totalPrice);
    }
}
