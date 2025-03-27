package views;

import step1.symbol.Operand;
import step2.domain.LottoGameResult;
import step2.domain.rank.RankCounter;
import step2.domain.rank.Rank;

public class ResultView {
    public static void printMessage(String message) {
        System.out.println(message);
    }



    public static void printResult(Operand result) {
        System.out.println("계산 결과는 " + result.value() + "입니다.");
    }

    public static void printResult(LottoGameResult lottoGameResult) {
        RankCounter rankCounters = lottoGameResult.getRankCounters();
        printMessage("당첨 통계\n---------");
        for (Rank rank : Rank.validValues()) {
            RankFormatter rankFormatter = rank.generateFormatter();
            String formattedRankInformation = rankFormatter.format("%d개 일치 (%d)원");
            String rankDisplayMessage = String.format("%s - %d개", formattedRankInformation, rankCounters.getCount(rank));
            printMessage(rankDisplayMessage);
        }
    }
}
