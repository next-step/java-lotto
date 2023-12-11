import config.LottoAppConfig;
import domain.Currency;
import domain.Lotto;
import domain.WinningLotto;
import repository.LottoGameResultRepository;
import service.LottoResultService;
import service.LottoSalesService;
import service.UserLottoService;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Optional;

public class LottoApplication {

    public static void main(String[] args) {
        LottoAppConfig appConfig = new LottoAppConfig();
        UserLottoService userLottoService = appConfig.userLottoService();
        LottoResultService lottoResultService = appConfig.lottoResultService();

        long money = InputView.inputLottoPurchaseAmount();
        int totalTicketCount = LottoSalesService.validateMoneyAndReturnTicketCount(money);

        int manualTicketCount = InputView.inputManualLottoCount();
        LottoSalesService.checkAvailableTicketCount(totalTicketCount, manualTicketCount);

        InputView.inputSelectedNumberInfo();
        for (int i = 0; i < manualTicketCount; i++) {
            String selectedNumber = InputView.inputSelectedNumber();
            userLottoService.buyManualLottoTickets(selectedNumber);
        }
        userLottoService.buyRandomLottoTickets(totalTicketCount - manualTicketCount);
        List<Lotto> lottoTickets = userLottoService.getAllLottoTickets();

        ResultView.printLottoCount(manualTicketCount, totalTicketCount - manualTicketCount);
        ResultView.printLottoNumbers(lottoTickets);

        String inputWinningNumbers = InputView.inputWinningNumbers();
        int inputBonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers, inputBonusNumber);

        Optional<Currency> optionalCurrency = Optional.of(Currency.KRW);
        LottoGameResultRepository lottoGameResult = lottoResultService.matchUserLotto(winningLotto);
        float rate = lottoResultService.calculateReturnRate(money, lottoGameResult, optionalCurrency);
        ResultView.printLottoGameResult(lottoGameResult, rate, optionalCurrency);
    }
}
