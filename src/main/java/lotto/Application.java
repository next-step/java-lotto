package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.formatter.OutputFomatter;
import lotto.view.printer.ConsolePrinter;
import lotto.view.printer.Printer;
import lotto.view.reader.ConsoleReader;
import lotto.view.reader.Reader;

public class Application {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();
        InputView inputView = InputView.of(reader, printer);

        OutputFomatter outputFomatter = new OutputFomatter();
        OutputView outputView = new OutputView(printer, outputFomatter);

        LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.run();
    }
}
