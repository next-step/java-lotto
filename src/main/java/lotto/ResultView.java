package lotto;

import static lotto.LottoRankEnum.*;

public class ResultView {

    private static final int PROFITABILITY_THRESHOLD = 1;

    public static void printResult(LottoResults lottoResults, int amount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + FIFTH.getPrize() + "원)- " + lottoResults.fifthPrize() + "개");
        System.out.println("4개 일치 (" + FOURTH.getPrize() + "원)- " + lottoResults.fourthPrize() + "개");
        System.out.println("5개 일치 (" + THIRD.getPrize() + "원)- " + lottoResults.thirdPrize() + "개");
        System.out.println("6개 일치 (" + FIRST.getPrize() + "원)- " + lottoResults.firstPrize() + "개");
        int winningPrize = calculateWinningPrize(lottoResults);
        double profitability = calculateProfitability(amount, winningPrize);
        System.out.print("총 수익률은 " + profitability + "입니다.");
        if (profitability < PROFITABILITY_THRESHOLD) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        } else {
            System.out.println("(기준이 1이기 때문에 결과적으로 이익이라는 의미임)");
        }
    }

    private static double calculateProfitability(int amount, int winningPrize) {
        return (double) winningPrize / amount;
    }

    private static int calculateWinningPrize(LottoResults lottoResults) {
        return lottoResults.fifthPrize() * FIFTH.getPrize() + lottoResults.fourthPrize() * FOURTH.getPrize() + lottoResults.thirdPrize() * THIRD.getPrize() + lottoResults.firstPrize() * FIRST.getPrize();
    }
}
