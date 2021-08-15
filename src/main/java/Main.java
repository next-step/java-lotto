import lotto.domain.*;
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
        int bonusNumber = inputView.receiveBonusNumber();
        Result result = lottoTickets.check(new WinningNumbers(winningNumbers, new LottoNumber(bonusNumber)));

        ResultView.print(result);
        scanner.close();
    }
}
