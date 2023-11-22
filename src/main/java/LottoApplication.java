import domain.Lotto;
import repository.LottoGameResultRepository;
import service.LottoResultService;
import repository.UserLottoRepository;
import service.UserLottoService;
import domain.Currency;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Optional;

public class LottoApplication {

    public static void main(String[] args) {
        UserLottoRepository userLottoRepository = new UserLottoRepository();
        UserLottoService userLottoService = new UserLottoService(userLottoRepository);

        long money = InputView.inputLottoPurchaseAmount();
        userLottoService.buyRandomLottoTickets(money);
        List<Lotto> lottoTickets = userLottoService.getAllLottoTickets();
        ResultView.printLottoCount(lottoTickets.size());
        ResultView.printLottoNumbers(lottoTickets);

        String inputWinningNumbers = InputView.inputWinningNumbers();
        Lotto winningLotto = new Lotto(inputWinningNumbers);

        Optional<Currency> optionalCurrency = Currency.fromCountryType("kor");
        LottoResultService lottoResultService = new LottoResultService(userLottoRepository);
        LottoGameResultRepository lottoGameResult = lottoResultService.matchUserLotto(winningLotto);
        float rate = lottoResultService.calculateReturnRate(money, lottoGameResult, optionalCurrency);
        ResultView.printLottoGameResult(lottoGameResult, rate, optionalCurrency);
    }
}
