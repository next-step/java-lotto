import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.domain.Result;
import lotto.generic.Money;
import lotto.util.LottoNumbersFactory;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        int purchaseAmount = inputView.receivePurchaseMoney();
        LottoTickets lottoTickets = LottoGame.buy(Money.wons(purchaseAmount));
        ResultView.print(lottoTickets.getLottoTickets());

        LottoNumbers winningNumbers = LottoNumbersFactory.makeLottoNumbers(inputView.receiveWinningNumbers());
        Result result = lottoTickets.check(winningNumbers);

        ResultView.print(result);
        scanner.close();
    }
}
