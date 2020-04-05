package lotto.view;

import lotto.model.Result;

import java.util.List;

public class ResultView {

    public void print(List<Result> gameResults) {
        // 4등
        System.out.println("3개 일치 (5000원)- " +
                gameResults.stream().filter(result -> result.getRank().getMatchCount() == 3).count());

        // 3등
        System.out.println("4개 일치 (50000원)- " +
                gameResults.stream().filter(result -> result.getRank().getMatchCount() == 4).count());

        // 2등
        System.out.println("5개 일치 (1500000원)- " +
                gameResults.stream().filter(result -> result.getRank().getMatchCount() == 5).count());

        // 1등
        System.out.println("6개 일치 (2000000000원)- " +
                gameResults.stream().filter(result -> result.getRank().getMatchCount() == 6).count());

    }

    public void printRevenue(List<Result> gameResults, int money) {
        int totalPrize = 0;
        for (Result result : gameResults) {
            totalPrize += result.getRank().getPrize();
        }
        double revenue = (double) totalPrize / money;

        System.out.println(String.format(
                "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 1보다 작으면 결과적으로 손해라는 의미임)",
                revenue
        ));
    }
}
