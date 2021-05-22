package lotto.ui;

import lotto.core.omr.OmrCard;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.info.OmrCardInputData;
import lotto.ui.input.info.RoundInputData;
import lotto.ui.output.GameOutput;
import lotto.ui.output.Output;
import lotto.ui.output.report.GameReport;

public class Program {
    private Output output;
    private Input input;

    public Program() {
        this.output = new GameOutput(System.out);
        this.input = new GameInput(System.in, output);
    }

    public void run() {
        OmrCard omrCard = new OmrCardInputData(input).get();
        Round round = new RoundInputData(input).get();

        GameReport report = new GameReport(omrCard, round);
        report.print(output);
    }

}