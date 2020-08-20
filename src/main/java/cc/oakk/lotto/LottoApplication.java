package cc.oakk.lotto;

import cc.oakk.lotto.controller.LottoGame;
import cc.oakk.lotto.model.*;
import cc.oakk.lotto.view.InputView;
import cc.oakk.lotto.view.InputViewImpl;
import cc.oakk.lotto.view.ResultView;
import cc.oakk.lotto.view.ResultViewImpl;
import cc.oakk.lotto.view.printer.LottoResultsPrinter;
import cc.oakk.lotto.view.printer.Printer;
import cc.oakk.lotto.view.printer.StandardPrinter;

public class LottoApplication {
    public static void main(String[] args) {
        Printer<String> stringPrinter = StandardPrinter.getInstance();
        LottoPrizeProvider<Long> provider = new SimpleLottoPrizeProvider();
        LottoResultsPrinter<Long> printer = new LottoResultsPrinter<>(provider);

        LottoGenerator lottoGenerator = new LottoGenerator();
        InputView inputView = new InputViewImpl();
        ResultView resultView = new ResultViewImpl(stringPrinter, printer);

        new LottoGame(lottoGenerator, inputView, resultView).start();
    }
}
