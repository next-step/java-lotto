import domain.Lotto;
import domain.LottoService;
import domain.WinningLotto;
import validator.LottoNumberValidator;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        Long money = InputView.inputLottoPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.generateLotto(money);
        ResultView.printLottoCount(lottoTickets.size());
        ResultView.printLottoNumbers(lottoTickets);

        String inputWinningNumbers = InputView.inputWinningNumbers();
        lottoService.generateWinningInfo(inputWinningNumbers);

    }
}
