import domain.Lotto;
import service.LottoGameService;
import repository.UserLottoRepository;
import domain.WinningLotto;
import service.UserLottoService;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        UserLottoRepository userLottoRepository = new UserLottoRepository();
        UserLottoService userLottoService = new UserLottoService(userLottoRepository);

        /**
         * 가격에 맞게 로또 구매
         */
        Long money = InputView.inputLottoPurchaseAmount();
        userLottoService.buyRandomLottoTickets(money);
        List<Lotto> lottoTickets = userLottoService.getAllLottoTickets();
        ResultView.printLottoCount(lottoTickets.size());
        ResultView.printLottoNumbers(lottoTickets);

        /**
         * 당첨번호 입력
         */
        LottoGameService lottoGame = new LottoGameService(userLottoRepository);
        String inputWinningNumbers = InputView.inputWinningNumbers();
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers);

        /**
         * userLotto와 당첨번호 당첨결과 확인
         */
        Map<Integer, Integer> lottoPrizeIntegerMap = lottoGame.matchUserLotto(winningLotto);
        ResultView.printLottoGameResult(lottoPrizeIntegerMap);

        /**
         * 당첨금액과 수익률 출력
         */
        float rate = lottoGame.calculateReturnRate(money, lottoPrizeIntegerMap);
        ResultView.printLottoReturnRate(rate);
    }
}
