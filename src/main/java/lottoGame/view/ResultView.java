package lottoGame.view;

import lottoGame.CountException;
import lottoGame.LottoGame;
import lottoGame.RankResult;
import lottoGame.dto.ResultParameter;

public class ResultView {
    private static final String start = "개를 구매했습니다.";
    private static final String startStatics = "당첨 통계";

    private static final String line = "\n---------\n";

    public static void printLottery(ResultParameter resultParameter) {
        System.out.println(resultParameter.getLotteryCount() + start);
        resultParameter.getLottoResult().forEach(autoLotto -> System.out.println(autoLotto.toString()));
    }

    public static void printStatistics(RankResult rankResult)  {
        System.out.printf("%s%s%n", startStatics, line);
        rankResult.getLotteryBoard().forEach((ranks, matchCount) ->
                System.out.printf("%s개 일치 (%s원)- %s개\n", ranks.getMatchNum(), ranks.getRank(), matchCount));
        System.out.printf("총 수익률은 %s 입니다.", rankResult.getYield());
    }
}
