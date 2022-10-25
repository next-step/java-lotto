package lottoGame.view;

import lottoGame.Rank;
import lottoGame.RankResult;
import lottoGame.model.InputParameter;
import lottoGame.model.lotto.Lottery;

public class ResultView {
    private static final String start = "개를 구매했습니다.";
    private static final String startStatics = "당첨 통계";

    private static final String line = "\n---------\n";

    private final Lottery lottery;

    public ResultView(Lottery lottery) {
        this.lottery = lottery;
    }

    public void printLottery() {
        System.out.println(lottery.countAllLotto() + start);
        lottery.getLottery().forEach(autoLotto -> System.out.println(autoLotto.toString()));
    }

    public void printStatistics(RankResult rankResult, InputParameter inputParameter) {
        System.out.printf("%s%s%n", startStatics, line);
        rankResult.getLotteryBoard().forEach((ranks, matchCount) ->
                System.out.printf("%s개 일치 (%s원)- %s개\n", ranks.getMatchNum(), ranks.getRank(), matchCount));
        System.out.printf("총 수익률은 %s 입니다.", rankResult.getYield(inputParameter.getAmount()));
    }
}
