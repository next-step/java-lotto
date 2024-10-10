package lotto.config;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class GameConfig {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Integer lottoTicketPrice;

    public GameConfig(InputHandler inputHandler, OutputHandler outputHandler, Integer lottoTicketPrice) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoTicketPrice = lottoTicketPrice;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public Integer getLottoTicketPrice() {
        return lottoTicketPrice;
    }
}
