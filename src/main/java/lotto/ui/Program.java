package lotto.ui;

import lotto.core.omr.OmrCard;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.request.RequestOmrCard;
import lotto.ui.input.request.RequestRound;
import lotto.ui.output.GameOutput;
import lotto.ui.output.Output;
import lotto.ui.output.report.GameReport;
import lotto.ui.output.report.NextStepProblemGameGameReport;
import lotto.ui.output.result.GameResult;

public class Program {
    public static final int PRICE_OF_ONE_GAME = 1000;

    private final Output output;
    private final Input<String> input;

    public Program() {
        this.output = new GameOutput(System.out);
        this.input = new GameInput(System.in, output);
    }

    public void run() {
        OmrCard omrCard = new RequestOmrCard(output, input).input();
        Round round = new RequestRound(output, input).input();

        reportPrint(omrCard, round);
    }

    private void reportPrint(final OmrCard omrCard, final Round round) {
        GameResult gameResult = new GameResult(omrCard, round);
        GameReport gameReport = new NextStepProblemGameGameReport();

        output.println(gameReport.format(gameResult));
    }

}