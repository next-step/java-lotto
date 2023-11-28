package lotto.controller;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.LottoShopFactory;
import lotto.domain.LottoType;
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
        List<List<String>> manuallyLotto = inputView.manuallyLottoInit();

        LottoShop lottoShop = LottoShop.from(MoneyWallet.of(money), LottoShopFactory.of(manuallyLotto));
        LottoWallet lottoWallet = lottoShop.purchase();
        resultView.calculateResult(lottoWallet.totalTicketCount());
        resultView.out(lottoWallet);

        List<LottoNumber> lastWeekLottoNumbers = createLastWeekLottoNumbers(inputView.lastWeekLottoInit());
        int bonusBall = inputView.bonusBallInit();
        WinningLotto winningLotto = WinningLotto.of(Lotto.winning(lastWeekLottoNumbers), new LottoNumber(bonusBall));

        StatisticsReport report = StatisticsReport.of(lottoWallet).report(winningLotto);
        resultView.resultOut(report);
        resultView.out(report.rate());
    }


    private List<LottoNumber> createLastWeekLottoNumbers(List<Integer> lastWeekLottoInit) {
        return lastWeekLottoInit.stream().map(LottoNumber::new)
            .collect(Collectors.toList());
    }


}
