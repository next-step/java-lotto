import domain.Lotto.LottoResult;
import domain.Lotto.LottoService;
import domain.Lotto.LottoTicket;
import domain.Lotto.WinningLotto;
import ui.OutputView;
import ui.InputView;

import java.util.ArrayList;
import java.util.List;


public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        int purchaseAmount = inputView.getPurchaseAmount();
        int manualTicketCount = inputView.getManualTicketCount();
        List<LottoTicket> manualTickets = inputView.getManualTickets(manualTicketCount);

        int autoTicketCount = (purchaseAmount / LOTTO_PRICE) - manualTicketCount;
        List<LottoTicket> autoTickets = lottoService.generateLottoTickets(autoTicketCount);

        List<LottoTicket> allTickets = concatTickets(manualTickets, autoTickets);

        outputView.printLottoPurchaseResult(manualTickets.size(), autoTickets.size(), allTickets);

        LottoTicket winningTicket = inputView.getWinningTicket();
        int bonusNumber = inputView.getBonusTicket();
        WinningLotto winningLotto = new WinningLotto(winningTicket, bonusNumber);

        LottoResult result = lottoService.calculateResults(allTickets, winningLotto);
        outputView.printResult(result);
    }

    private static List<LottoTicket> concatTickets(List<LottoTicket> manual, List<LottoTicket> auto) {
        List<LottoTicket> combined = new ArrayList<>(manual);
        combined.addAll(auto);
        return combined;
    }
}
