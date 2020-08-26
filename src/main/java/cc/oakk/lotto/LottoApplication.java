package cc.oakk.lotto;

import cc.oakk.lotto.controller.LottoGame;
import cc.oakk.lotto.model.*;
import cc.oakk.lotto.model.prizeprovider.LottoPrizeProvider;
import cc.oakk.lotto.model.prizeprovider.impl.SimpleLottoPrizeProvider;
import cc.oakk.lotto.view.InputView;
import cc.oakk.lotto.view.impl.InputConsoleView;
import cc.oakk.lotto.view.ResultView;
import cc.oakk.lotto.view.impl.ResultConsoleView;
import cc.oakk.lotto.view.printer.LottoResultsPrinter;
import cc.oakk.lotto.view.printer.Printer;
import cc.oakk.lotto.view.printer.StandardPrinter;

public class LottoApplication {
    public static void main(String[] args) {
        Printer<String> stringPrinter = StandardPrinter.getInstance();
        LottoPrizeProvider<Long> provider = new SimpleLottoPrizeProvider();
        LottoResultsPrinter<Long> printer = new LottoResultsPrinter<>(provider, LottoGenerator.LOTTO_PRICE);

        LottoGenerator lottoGenerator = new LottoGenerator();
        InputView inputView = new InputConsoleView();
        ResultView resultView = new ResultConsoleView(stringPrinter, printer);

        new LottoGame(lottoGenerator, inputView, resultView).start();
    }
}
