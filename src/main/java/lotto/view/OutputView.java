package lotto.view;

import lotto.view.formatter.OutputFomatter;
import lotto.view.printer.Printer;

public class OutputView {
    private final Printer printer;
    private final OutputFomatter formatter;

    public OutputView(Printer printer, OutputFomatter formatter) {
        this.printer = printer;
        this.formatter = formatter;
    }
}
