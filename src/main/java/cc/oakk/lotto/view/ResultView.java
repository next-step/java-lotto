package cc.oakk.lotto.view;

import cc.oakk.lotto.model.LottoResults;
import cc.oakk.lotto.model.Lottos;
import cc.oakk.lotto.view.printer.Printable;

public interface ResultView {
    void repeatPurchasedLottoCount(int count, int manualCount);
    void printLottos(Printable<Lottos> lottosPrintable);

    void printResultHeader();
    void printLottoResults(Printable<LottoResults> lottoResultsPrintable);
}
