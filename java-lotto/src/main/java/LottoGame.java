import domain.Lotto.LottoResult;
import domain.Lotto.LottoService;
import domain.Lotto.LottoTicket;
import domain.Lotto.WinningLotto;
import domain.Lotto.LottoNo;
import ui.OutputView;
import ui.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        int purchaseAmount = inputView.getPurchaseAmount();
        int manualTicketCount = inputView.getManualTicketCount();
        List<List<Integer>> manualNumbers = inputView.getManualLottoNumbers(manualTicketCount);

        List<LottoTicket> manualTickets = manualNumbers.stream()
                .map(numbers -> new LottoTicket(numbers.stream()
                        .map(LottoNo::new)
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());

        int autoTicketCount = (purchaseAmount / LOTTO_PRICE) - manualTicketCount;
        List<LottoTicket> autoTickets = lottoService.generateLottoTickets(autoTicketCount);

        List<LottoTicket> allTickets = concatTickets(manualTickets, autoTickets);

        outputView.printLottoPurchaseResult(manualTickets.size(), autoTickets.size(), allTickets);

        WinningLotto winningLotto = inputView.getWinningLotto();

        LottoResult result = lottoService.calculateResults(allTickets, winningLotto);
        outputView.printResult(result,purchaseAmount);
    }

    private static List<LottoTicket> concatTickets(List<LottoTicket> manual, List<LottoTicket> auto) {
        return Stream.concat(manual.stream(), auto.stream())
                .collect(Collectors.toList());
    }
}
