import domain.Lotto.*;
import ui.OutputView;
import ui.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        int purchaseAmount = inputView.getPurchaseAmount();
        int manualTicketCount = inputView.getManualTicketCount();

        LottoRequest request = new LottoRequest(
                manualTicketCount,
                inputView.getManualLottoNumbers(manualTicketCount)
        );

        Lottos lottos = lottoService.generateLottos(request, purchaseAmount);

        outputView.printLottoPurchaseResult(
                request.getManualTicketCount(),
                lottos.getAutoTicketCount(),
                lottos.getTickets()
        );

        WinningLotto winningLotto = inputView.getWinningLotto();
        LottoResult result = lottoService.calculateResults(lottos.getTickets(), winningLotto);

        outputView.printResult(result, purchaseAmount);
    }
}