package lotto.ui;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.core.omr.OmrCard;
import lotto.core.round.Rank;
import lotto.core.round.Round;
import lotto.ui.report.Report;

public class Program {
    private GameInput gameInput;
    private GameOutput gameOutput;

    public Program() {
        this.gameOutput = new GameOutput();
        this.gameInput = new GameInput(gameOutput, new Scanner(System.in));
    }

    public void run() {
        OmrCard omrCard = gameInput.inputOmrInfo();
        Round round = gameInput.inputRound();

        Report report = omrCard.getReport(round);
        print(report);
    }

    public void print(Report report) {
        gameOutput.println("당첨 통계");
        gameOutput.println("---------");
        gameOutput.println(statisticsToString(x->report.getRankFormat(x), Rank.FIFTH, Rank.FOURTH, Rank.SECOND, Rank.FIRST));
        gameOutput.println(yieldsToString(report.getYields()));
    }

    private String statisticsToString(Function<Rank, String> function, Rank ...ranks) {
        return Arrays.stream(ranks)
            .map(rank->function.apply(rank))
            .collect(Collectors.joining("\n"));
    }

    private String yieldsToString(double yields) {
        return String.format("총 수익률은 %.2f입니다.%s", yields, yields < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "");
    }

}