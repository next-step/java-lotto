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

    public LottoController(Scanner scanner, PrintStream out) {
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

        List<LottoNumber> lastWeakLottoNumbers = createLastWeakLottoNumbers(inputView.lastWeakLottoInit());
        int bonusBall = inputView.bonusBallInit();
        WinningLotto winningLotto = WinningLotto.of(new Lotto(lastWeakLottoNumbers), new LottoNumber(bonusBall));

        StatisticsReport report = StatisticsReport.of(lottoWallet).report(winningLotto);
        resultView.out(report);
        resultView.out(report.rate());
    }

    private LottoWallet purchaseLotto(int money) {
        MoneyWallet moneyWallet = new MoneyWallet(money);
        LottoWallet lottoWallet = LottoShop.from(money).purchase();
        moneyWallet = moneyWallet.withdraw(lottoWallet.totalPurchaseAmount());
        return lottoWallet;
    }

    private List<LottoNumber> createLastWeakLottoNumbers(List<Integer> lastWeakLottoInit) {
        return lastWeakLottoInit.stream().map(LottoNumber::new)
            .collect(Collectors.toList());
    }


}
