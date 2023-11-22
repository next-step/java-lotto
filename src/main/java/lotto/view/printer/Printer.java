package lotto.view.printer;

public interface Printer {
    void printLine(String message);

    void printLine(String format, Object... args);

    void printEmptyLine();
}
