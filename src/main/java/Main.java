import lotto.domain.*;
import lotto.generic.Money;
import lotto.util.StringUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        int purchaseAmount = inputView.receivePurchaseMoney();
        int manualLottoCount = inputView.receiveManualLottoCount();
        String[] manualLottoNumbers = inputView.receiveManualLottoNumbers(manualLottoCount);

        LottoTickets lottoTickets = LottoGame.buy(Money.wons(purchaseAmount), manualLottoNumbers);
        ResultView.print(lottoTickets);

        LottoNumbers winningNumbers = new LottoNumbers(StringUtil.split(inputView.receiveWinningNumbers()));
        LottoNumber bonusNumber = new LottoNumber(inputView.receiveBonusNumber());
        Result result = lottoTickets.check(new WinningNumbers(winningNumbers, bonusNumber));

        ResultView.print(result);
        scanner.close();
    }
}
