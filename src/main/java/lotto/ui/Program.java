package lotto.ui;

import java.util.Scanner;
import lotto.core.omr.OmrCard;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.output.GameOutput;
import lotto.ui.output.Output;
import lotto.ui.output.report.GameReport;

public class Program {
    private GameInput gameInput;
    private Output output;

    public Program() {
        this.output = new GameOutput();
        this.gameInput = new GameInput(output, new Scanner(System.in));
    }

    public void run() {
        OmrCard omrCard = gameInput.inputOmrInfo();
        Round round = gameInput.inputRound();

        GameReport report = new GameReport(omrCard, round);
        report.print(output);
    }

}