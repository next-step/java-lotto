package lotto;

import java.util.Arrays;

public class ResultView {
    public static void createLottoResultView(LottoGame lottoGame, Lotto winnerLotto) {

        createWinningStatisticsView(lottoGame, winnerLotto);
        createRateOfReturnView(lottoGame, winnerLotto);
    }

    private static void createWinningStatisticsView(LottoGame lottoGame, Lotto winnerLotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoPrize.values())
                .forEach(item ->
                        System.out.println(item.getMatchCount() + "개 일치 (" + item.getPrize() + ")" + lottoGame.matchLottoCount(item, winnerLotto) + "개"));
    }

    private static void createRateOfReturnView(LottoGame lottoGame, Lotto winnerLotto) {
        double rateOfReturn = lottoGame.getRateOfReturn(winnerLotto);
        System.out.println("총 수익률은 " + String.format("%.2f", rateOfReturn) + "입니다.(기준이 1이기 때문에 결과적으로 " + resultString(rateOfReturn) + "라는 의미임)");
    }


    private static String resultString(double rateOfReturn) {
        if (rateOfReturn > 1) {
            return "이득이";
        }

        if (rateOfReturn == 1) {
            return "본전이";
        }

        return "손해";
    }
}
