import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoNumberExtractor lottoNumberExtractor = new LottoNumberRandomExtractor();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberExtractor);

        int purchasePrice = inputView.getPurchasePrice();
        int manualSize = inputView.getManualSize();
        List<List<Integer>> manualLottoNumbers = inputView.getManualLottoNumbers(manualSize);

        LottoTickets lottoTickets = lottoMachine.makeLottoTickets(purchasePrice, manualLottoNumbers);
        resultView.printLottoTicketSize(manualSize, lottoTickets.size() - manualSize);
        List<String> lottoTicketStrings = lottoTickets.getLottoTicketStrings();
        resultView.printLottoTickets(lottoTicketStrings);

        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();
        WinningTicket winningTicket = WinningTicket.of(winningNumbers, bonusNumber);
        LottoResult lottoResult = lottoTickets.getMatchResult(winningTicket);

        resultView.printLottoStatistics(lottoResult.getWinningResult());
        resultView.printRate(lottoResult.calculateRate(lottoTickets.getPurchasePrice()));

    }
}
