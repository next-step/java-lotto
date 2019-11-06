package step2_bak.Data;

import step2_bak.Prize;

import java.util.ArrayList;
import java.util.List;

public class AnalysisData {
    private static final String WINNING_COUNT_POSTFIX = "개 일치 (";
    private static final String WINNING_PRIZE_POSTFIX = ") - ";
    private static final String WINNING_GAME_POSTFIX = "개";
    private static final String WINNING_RATE_PREFIX = "총 수익률은 ";
    private static final String WINNING_REPORT_PREFIX = "입니다.(기준이 1이기 때문에 결과적으로 ";
    private static final String WINNING_REPORT_POSTFIX = "(이)라는 의미임)";
    private static final String GAIN = "이득";
    private static final String LOSS = "손해";


    private List<String> earningMoneys;
    private String winningRate;

    public AnalysisData(int[] gameResult, float earning, int minPrize) {
        this.earningMoneys = getEarningMoneys(gameResult, minPrize);
        this.winningRate = winningRate(earning);
    }

    public List<String> getEarningMoneys() {
        return this.earningMoneys;
    }

    public String getWinningRate() {
        return this.winningRate;
    }

    private List<String> getEarningMoneys(int[] gameResult, int minPrize) {
        List<String> earningMoneys = new ArrayList<>();
        for ( int index = minPrize; index < gameResult.length; index++ ) {
            earningMoneys.add(index + WINNING_COUNT_POSTFIX + Prize.getMoney(index) + WINNING_PRIZE_POSTFIX + gameResult[index] + WINNING_GAME_POSTFIX);
        }
        return earningMoneys;
    }

    private String winningRate(float earning) {
        return WINNING_RATE_PREFIX + earning + WINNING_REPORT_PREFIX + (earning > 1 ? GAIN : LOSS) + WINNING_REPORT_POSTFIX;
    }

}
