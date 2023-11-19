package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in), System.out);
        ResultView resultView = new ResultView(System.out);

        int money = inputView.lottoInitCount();

        MoneyWallet moneyWallet = new MoneyWallet(money);
        LottoWallet lottoWallet = LottoShop.buy(moneyWallet);
        moneyWallet = lottoWallet.withdrawMoney(moneyWallet);
        resultView.calculateResult(lottoWallet.totalTicketCount());
        resultView.out(lottoWallet);

        List<Integer> lastWeakLottoInit = inputView.lastWeakLottoInit();
        WinningLotto winningLotto = WinningLotto.from(Lotto.from(lastWeakLottoInit));

        StatisticsReport report = StatisticsReport.of(lottoWallet).report(winningLotto);
        PAndLReport pAndLReport = PAndLReport.of(report);
        BigDecimal rate = pAndLReport.rate();
        System.out.println(rate);
    }

}
