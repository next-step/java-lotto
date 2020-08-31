package cc.oakk.lotto.view.printer.impl;

import cc.oakk.lotto.model.Lotto;
import cc.oakk.lotto.model.Lottos;
import cc.oakk.lotto.view.printer.Printer;
import cc.oakk.lotto.view.printer.StringPrinter;

import java.util.stream.Collectors;

public class LottosPrinter extends StringPrinter<Lottos> {
    public LottosPrinter() {
    }

    public LottosPrinter(Printer<String> stringPrinter) {
        super(stringPrinter);
    }

    @Override
    public void print(Lottos target) {
        String result = target.get()
                .stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));

        stringPrinter.print(result);
    }
}
