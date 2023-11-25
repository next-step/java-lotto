package step3.view;

import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoResult;
import step3.domain.lotto.Rank;

import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoNumbers(LottoNumber lottoNumber) {
        String result = lottoNumber.getNumbers()
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
        System.out.println("[" + result + "]");
    }

    public static void result(int purchaseAmount, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalWinningMoney = 0;
        for (Rank rank : lottoResult.getRankMap().keySet()) {
            if (rank.isNoMatch()) {
                continue;
            }
            totalWinningMoney += rank.getWinningMoney() * lottoResult.getRankMap().get(rank);
            System.out.println(rank + " - " + lottoResult.getRankMap().get(rank) + "개");
        }

        calculateRevenueRate(purchaseAmount, totalWinningMoney);
    }

    private static void calculateRevenueRate(int purchaseAmount, int totalWinningAmount) {
        double revenueRate = Math.floor((totalWinningAmount / (double) purchaseAmount) * 100) / 100;
        System.out.println("총 수익률은 " + revenueRate + "입니다.");
    }
}
