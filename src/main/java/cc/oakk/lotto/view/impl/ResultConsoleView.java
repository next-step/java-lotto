package cc.oakk.lotto.view.impl;

import cc.oakk.lotto.model.LottoResults;
import cc.oakk.lotto.view.ResultView;
import cc.oakk.lotto.view.printer.Printable;
import cc.oakk.lotto.view.printer.Printer;

public class ResultConsoleView implements ResultView {
    private final Printer<String> stringPrinter;
    private final Printer<LottoResults> lottoResultsPrinter;

    public ResultConsoleView(Printer<String> stringPrinter, Printer<LottoResults> lottoResultsPrinter) {
        this.stringPrinter = stringPrinter;
        this.lottoResultsPrinter = lottoResultsPrinter;
    }


    @Override
    public void repeatPurchasedLottoCount(int count) {
        stringPrinter.print(String.format("%d개를 구매했습니다.", count)::toString);
    }

    @Override
    public void printLottos(Printable<String> lottosPrintable) {
        stringPrinter.print(lottosPrintable);
    }

    @Override
    public void printResultHeader() {
        stringPrinter.print("\n당첨 통계\n---------"::toString);
    }

    @Override
    public void printLottoResults(Printable<LottoResults> lottoResultsPrintable) {
        lottoResultsPrinter.print(lottoResultsPrintable);
    }
}
