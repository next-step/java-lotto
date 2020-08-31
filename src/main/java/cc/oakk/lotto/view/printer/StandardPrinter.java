package cc.oakk.lotto.view.printer;

public class StandardPrinter implements Printer<String> {
    private static StandardPrinter INSTANCE;

    private StandardPrinter() {}

    public static StandardPrinter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StandardPrinter();
        }
        return INSTANCE;
    }

    public void print(String target) {
        System.out.println(target);
    }
}
