package lotto.ui;

import java.util.Scanner;
import lotto.core.omr.OmrCard;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.info.OmrCardInfo;
import lotto.ui.input.info.RoundInfo;
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
        OmrCard omrCard = new OmrCardInfo(input).get();
        Round round = new RoundInfo(input).get();

        GameReport report = new GameReport(omrCard, round);
        report.print(output);
    }

}