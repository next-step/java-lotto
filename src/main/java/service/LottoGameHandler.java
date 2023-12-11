package service;

import config.LottoAppConfig;
import domain.Currency;
import domain.Lotto;
import domain.WinningLotto;
import repository.LottoGameResultRepository;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Optional;

public class LottoGameHandler {

    private final UserLottoService userLottoService;
    private final LottoResultService lottoResultService;

    public LottoGameHandler(LottoAppConfig appConfig) {
        this.userLottoService = appConfig.userLottoService();
        this.lottoResultService = appConfig.lottoResultService();
    }

    public void runGame() {
        long money = InputView.inputLottoPurchaseAmount();
        int totalTicketCount = LottoSalesService.validateMoneyAndReturnTicketCount(money);

        int manualTicketCount = InputView.inputManualLottoCount();
        LottoSalesService.checkAvailableTicketCount(totalTicketCount, manualTicketCount);

        List<Lotto> lottoTickets = buyManualTicket(totalTicketCount, manualTicketCount);
        printAllLottoTickets(manualTicketCount, totalTicketCount-manualTicketCount, lottoTickets);

        WinningLotto winningLotto = generateWinningLotto();

        printLottoGameResults(money, winningLotto);
    }

    private static WinningLotto generateWinningLotto() {
        String inputWinningNumbers = InputView.inputWinningNumbers();
        int inputBonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers, inputBonusNumber);
        return winningLotto;
    }

    private static void printAllLottoTickets(int manualTicketCount, int autoTicketCount, List<Lotto> lottoTickets) {
        ResultView.printLottoCount(manualTicketCount, autoTicketCount);
        ResultView.printLottoNumbers(lottoTickets);
    }

    private List<Lotto> buyManualTicket(int totalTicketCount, int manualTicketCount) {
        InputView.inputSelectedNumberInfo();
        for (int i = 0; i < manualTicketCount; i++) {
            String selectedNumber = InputView.inputSelectedNumber();
            userLottoService.buyManualLottoTickets(selectedNumber);
        }
        userLottoService.buyRandomLottoTickets(totalTicketCount - manualTicketCount);
        List<Lotto> lottoTickets = userLottoService.getAllLottoTickets();
        return lottoTickets;
    }

    private void printLottoGameResults(long money, WinningLotto winningLotto) {
        Optional<Currency> optionalCurrency = Optional.of(Currency.KRW);
        LottoGameResultRepository lottoGameResult = lottoResultService.matchUserLotto(winningLotto);
        float rate = lottoResultService.calculateReturnRate(money, lottoGameResult, optionalCurrency);
        ResultView.printLottoGameResult(lottoGameResult, rate, optionalCurrency);
    }
}
