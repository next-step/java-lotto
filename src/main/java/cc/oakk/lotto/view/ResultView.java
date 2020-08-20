package cc.oakk.lotto.view;

import cc.oakk.lotto.model.LottoResults;
import cc.oakk.lotto.view.printer.Printable;

public interface ResultView {
    void printMoneyInputHeader();
    void repeatPurchasedLottoCount(int count);
    void printLottos(Printable<String> lottosPrintable);

    void printWinningNumberInputHeader();

    void printResultHeader();
    void printLottoResults(Printable<LottoResults> lottoResultsPrintable);

}
