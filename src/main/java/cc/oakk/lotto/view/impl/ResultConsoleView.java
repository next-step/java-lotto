package cc.oakk.lotto.view.impl;

import cc.oakk.lotto.model.LottoResults;
import cc.oakk.lotto.model.Lottos;
import cc.oakk.lotto.view.ResultView;
import cc.oakk.lotto.view.printer.Printable;
import cc.oakk.lotto.view.printer.Printer;

public class ResultConsoleView implements ResultView {
    private final Printer<String> stringPrinter;
    private final Printer<Lottos> lottosPrinter;
    private final Printer<LottoResults> lottoResultsPrinter;

    public ResultConsoleView(Printer<String> stringPrinter, Printer<Lottos> lottosPrinter, Printer<LottoResults> lottoResultsPrinter) {
        this.stringPrinter = stringPrinter;
        this.lottosPrinter = lottosPrinter;
        this.lottoResultsPrinter = lottoResultsPrinter;
    }

    @Override
    public void repeatPurchasedLottoCount(int count) {
        stringPrinter.print(String.format("%d개를 구매했습니다.", count));
    }

    @Override
    public void printLottos(Printable<Lottos> lottosPrintable) {
        lottosPrintable.print(lottosPrinter);
    }

    @Override
    public void printResultHeader() {
        stringPrinter.print("\n당첨 통계\n---------");
    }

    @Override
    public void printLottoResults(Printable<LottoResults> lottoResultsPrintable) {
        lottoResultsPrintable.print(lottoResultsPrinter);
    }
}
