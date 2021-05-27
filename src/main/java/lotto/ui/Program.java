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
import lotto.ui.output.result.GameResult;
import lotto.ui.output.report.NextStepProblemGameGameReport;

public class Program {
    private final Output output;
    private final Input input;

    public Program() {
        this.output = new GameOutput(System.out);
        this.input = new GameInput(System.in, output);
    }

    public void run() {
        OmrCard omrCard = new OmrCardInputData(input).input();
        Round round = new RoundInputData(input).input();

        reportPrint(omrCard, round);
    }

    private void reportPrint(OmrCard omrCard, Round round) {
        GameResult gameResult = new GameResult(omrCard, round);
        GameReport gameReport = new NextStepProblemGameGameReport();

        output.println(gameReport.format(gameResult));
    }

}