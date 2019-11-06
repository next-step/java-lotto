package step2_bak.View;

import step2_bak.Data.AnalysisData;
import step2_bak.Game;

import java.util.List;

public class ResultView {
    private static final String RESULT = "당첨 통계\n---------";

    public static void checkout(List<Game> games) {
        games.forEach(game -> System.out.println(game.gameNumbers()));
        System.out.println();
    }

    public static void print(AnalysisData analysisData) {
        System.out.println();
        System.out.println(RESULT);
        analysisData.getEarningMoneys().forEach(System.out :: println);
        System.out.println(analysisData.getWinningRate());
    }
}
