package lotto_second;

import lotto_second.domain.LottoTickets;
import lotto_second.domain.LottoWinner;
import lotto_second.service.LottoResult;
import lotto_second.service.LottoService;
import lotto_second.util.LottoValidate;
import lotto_second.view.InputView;
import lotto_second.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();
        LottoResult lottoResult = new LottoResult();


        String maxTicket = inputView.getPurchaseAmount();
        String manualTicket = inputView.getManualPurchaseAmount();

        Integer maxTicketCount = LottoValidate.maxTicketCount(maxTicket);
        Integer manualTicketCount = LottoValidate.manualTicketCount(maxTicketCount, manualTicket);
        Integer autoPurchaseCount = LottoValidate.autoTicketCount(maxTicketCount, manualTicketCount);

        List<String> manualInputTicket = inputView.getManualNumbers(manualTicketCount);


        LottoTickets manualLottoTickets = lottoService.parseManualTickets(manualInputTicket);
        LottoTickets autoLottoTickets = lottoService.generateAutoTickets(autoPurchaseCount);

        resultView.printLottoResult(manualLottoTickets, autoLottoTickets);

        String winningNumbers = inputView.getWinningNumbers();
        String bonusNumber = inputView.getBonusNumber();

        LottoWinner lottoWinner = new LottoWinner(winningNumbers, bonusNumber);
        lottoWinner.numberDuplicateInspection();

        LottoTickets allLottoTickets = new LottoTickets(new ArrayList<>());
        allLottoTickets.add(manualLottoTickets);
        allLottoTickets.add(autoLottoTickets);


        lottoResult.calculateResult(allLottoTickets, lottoWinner);
        resultView.printStatistics(lottoResult);
    }
}
