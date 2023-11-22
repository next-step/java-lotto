package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.view.formatter.OutputFomatter;
import lotto.view.printer.Printer;

public class OutputView {
    private final Printer printer;
    private final OutputFomatter formatter;

    public OutputView(Printer printer, OutputFomatter formatter) {
        this.printer = printer;
        this.formatter = formatter;
    }

    public void printLottoCount(LottoCount lottoCount) {
        int count = formatter.toLottoCount(lottoCount);
        printer.printLine("%d개를 구매했습니다.", count);
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(this::printLotto);
    }

    private void printLotto(Lotto rawLotto) {
        String lotto = formatter.toLotto(rawLotto);
        printer.printLine("[%s]", lotto);
    }
}
