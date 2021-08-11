import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.domain.Result;
import lotto.generic.Money;
import lotto.util.LottoNumbersFactory;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.receivePurchaseMoney();
        LottoTickets lottoTickets = LottoGame.buy(Money.wons(purchaseAmount));
        ResultView.print(lottoTickets.getLottoTickets());

        LottoNumbers winningNumbers = LottoNumbersFactory.makeLottoNumbers(InputView.receiveWinningNumbers());
        Result result = lottoTickets.check(winningNumbers);
        ResultView.print(result);
    }
}
