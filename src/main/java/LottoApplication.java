import domain.Lotto;
import domain.LottoService;
import domain.LottoWinningInfo;
import policy.SplitWinningNumber;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        Long money = InputView.inputLottoPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.generateLotto(money);
        ResultView.printLottoNumbers(lottoTickets);

        String InputWinningNumbers = InputView.inputWinningNumbers();
        String[] winningNumbers = SplitWinningNumber.splitByComma(InputWinningNumbers);
        LottoWinningInfo winnerNumber = new LottoWinningInfo(Arrays.asList(winningNumbers));

    }
}
