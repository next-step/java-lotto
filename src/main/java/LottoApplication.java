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

        /**
         * 가격에 맞게 로또 구매
         */
        long money = InputView.inputLottoPurchaseAmount();
        userLottoService.buyRandomLottoTickets(money);
        List<Lotto> lottoTickets = userLottoService.getAllLottoTickets();
        ResultView.printLottoCount(lottoTickets.size());
        ResultView.printLottoNumbers(lottoTickets);

        /**
         * 당첨번호 입력
         */
        String inputWinningNumbers = InputView.inputWinningNumbers();
        Lotto winningLotto = new Lotto(inputWinningNumbers);

        /**
         * 로또 당첨결과 확인 및 출력
         */
        Optional<Currency> optionalCurrency = Currency.fromCountryType("kor");
        LottoResultService lottoResultService = new LottoResultService(userLottoRepository);
        LottoGameResultRepository lottoGameResult = lottoResultService.matchUserLotto(winningLotto);
        float rate = lottoResultService.calculateReturnRate(money, lottoGameResult, optionalCurrency);
        ResultView.printLottoGameResult(lottoGameResult, rate, optionalCurrency);
    }
}
