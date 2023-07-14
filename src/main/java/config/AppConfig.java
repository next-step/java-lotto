package config;

import controller.LottoController;
import service.LottoService;
import view.ConsoleInputReader;
import view.ConsoleOutputWriter;
import view.InputReader;
import view.OutputWriter;

public class AppConfig {

    private AppConfig() {
        /* no-op */
    }

    public static LottoController lottoController() {
        return new LottoController(lottoService());
    }

    private static LottoService lottoService() {
        return new LottoService();
    }

    public static InputReader inputReader() {
        return new ConsoleInputReader();
    }

    public static OutputWriter outputWriter() {
        return new ConsoleOutputWriter();
    }
}
