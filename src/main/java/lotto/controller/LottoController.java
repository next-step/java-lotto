package lotto.controller;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.LottoWallet;
import lotto.domain.MoneyWallet;
import lotto.domain.StatisticsReport;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    private LottoController(Scanner scanner, PrintStream out) {
        this.inputView = new InputView(scanner, System.out);
        this.resultView = new ResultView(System.out);
    }

    public static LottoController of(Scanner scanner, PrintStream out) {
        return new LottoController(scanner, out);
    }

    public void start() {
        int money = inputView.lottoInitCount();

        LottoWallet lottoWallet = purchaseLotto(money);
        resultView.calculateResult(lottoWallet.totalTicketCount());
        resultView.out(lottoWallet);

        List<LottoNumber> lastWeekLottoNumbers = createLastWeekLottoNumbers(inputView.lastWeekLottoInit());
        int bonusBall = inputView.bonusBallInit();
        WinningLotto winningLotto = WinningLotto.of(new Lotto(lastWeekLottoNumbers), new LottoNumber(bonusBall));

        StatisticsReport report = StatisticsReport.of(lottoWallet).report(winningLotto);
        resultView.resultOut(report);
        resultView.out(report.rate());
    }

    private LottoWallet purchaseLotto(int money) {
        MoneyWallet moneyWallet = new MoneyWallet(money);
        LottoWallet lottoWallet = LottoShop.from(money).purchase();
        moneyWallet = moneyWallet.withdraw(lottoWallet.totalPurchaseAmount());
        return lottoWallet;
    }

    private List<LottoNumber> createLastWeekLottoNumbers(List<Integer> lastWeekLottoInit) {
        return lastWeekLottoInit.stream().map(LottoNumber::new)
            .collect(Collectors.toList());
    }


}
