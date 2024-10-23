package lotto;

import java.util.List;

import static lotto.LottoRank.*;

public class ResultView {

    private static final int PROFITABILITY_THRESHOLD = 1;

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
        System.out.println();
    }

    public static void printQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printResult(LottoResults lottoResults, int amount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + FIFTH.getPrize() + "원)- " + lottoResults.fifthPrize() + "개");
        System.out.println("4개 일치 (" + FOURTH.getPrize() + "원)- " + lottoResults.fourthPrize() + "개");
        System.out.println("5개 일치 (" + THIRD.getPrize() + "원)- " + lottoResults.thirdPrize() + "개");
        System.out.println("6개 일치 (" + FIRST.getPrize() + "원)- " + lottoResults.firstPrize() + "개");
        int winningPrize = lottoResults.calculateWinningPrize();
        double profitability = lottoResults.calculateProfitability(amount, winningPrize);
        System.out.print("총 수익률은 " + profitability + "입니다.");
        if (profitability < PROFITABILITY_THRESHOLD) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        } else {
            System.out.println("(기준이 1이기 때문에 결과적으로 이익이라는 의미임)");
        }
    }
}
