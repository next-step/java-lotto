package view;

import lotto.domain.Games;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.Comparator;
import java.util.Map;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return instance;
    }

    public void printCalculationResult(int result) {
        System.out.println("계산 결과 : " + result);
    }

    public void printPurchasedGames(Games games) {
        System.out.println(games.count() + "개를 구매했습니다.");
        System.out.println(games);
        System.out.println();
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        printEachRankResult(lottoResult);
        printEarningRate(lottoResult);
    }

    private void printEarningRate(LottoResult lottoResult) {
        double earningRate = lottoResult.calculateEarningRate();
        final int breakEven = 1;

        String profit = "수익";
        if (earningRate < breakEven) {
            profit = "손해";
        }

        System.out.println(String.format("총 수익률은 %.2f입니다. (%s)", earningRate, profit));
    }

    private void printEachRankResult(LottoResult lottoResult) {
        Map<Rank, Integer> result = lottoResult.countPerRank();
        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .filter(entry -> entry.getKey() != Rank.NONE)
                .forEach(entry -> {
                    Rank rank = entry.getKey();
                    int hit = rank.getHit();
                    int prize = rank.getPrize();
                    int frequency = entry.getValue();

                    String bonusMessage = rank == Rank.SECOND ? ", 보너스 볼 일치" : "";
                    System.out.println(String.format("%s개 일치%s (%d원) - %d개", hit, bonusMessage, prize, frequency));
                });
    }
}
