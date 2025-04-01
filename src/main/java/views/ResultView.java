package views;

import step1.symbol.Operand;
import step2.domain.LottoGameResult;
import step2.domain.rank.RankCounter;
import step2.domain.rank.RankType;

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
        for (RankType rank : RankType.validValues()) {
            String additionalDescription = rank.getAdditionalDescription();
            RankFormatter rankFormatter = new RankFormatter(rank);

            String format = "%d개 일치 (%d)원";
            if (additionalDescription != null) {
                format = "%d개 일치, " + additionalDescription + " (%d)원";
            }

            String formattedRankInformation = rankFormatter.format(format);
            String rankDisplayMessage = String.format("%s- %d개", formattedRankInformation, rankCounters.getCount(rank));
            printMessage(rankDisplayMessage);
        }
    }
}
