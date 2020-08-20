package cc.oakk.lotto.view.printer;

public interface Printer<T> {
    void print(Printable<T> printable);
}
