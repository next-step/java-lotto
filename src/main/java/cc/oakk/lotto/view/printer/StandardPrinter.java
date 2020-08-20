package cc.oakk.lotto.view.printer;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class StandardPrinter implements Printer<String> {
    private static StandardPrinter INSTANCE;

    private StandardPrinter() {}

    public static StandardPrinter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StandardPrinter();
        }
        return INSTANCE;
    }

    public void print(Printable<String> printable) {
        System.out.println(throwIfNull(printable).print());
    }
}
