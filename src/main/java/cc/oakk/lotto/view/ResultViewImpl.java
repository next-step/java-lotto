package cc.oakk.lotto.view;

import cc.oakk.lotto.model.LottoResults;
import cc.oakk.lotto.view.printer.Printable;
import cc.oakk.lotto.view.printer.Printer;

public class ResultViewImpl implements ResultView {
    private final Printer<String> stringPrinter;
    private final Printer<LottoResults> lottoResultsPrinter;

    public ResultViewImpl(Printer<String> stringPrinter, Printer<LottoResults> lottoResultsPrinter) {
        this.stringPrinter = stringPrinter;
        this.lottoResultsPrinter = lottoResultsPrinter;
    }

    @Override
    public void printMoneyInputHeader() {
        stringPrinter.print("구입금액을 입력해 주세요."::toString);
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
    public void printWinningNumberInputHeader() {
        stringPrinter.print("\n지난 주 당첨 번호를 입력해 주세요."::toString);
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
