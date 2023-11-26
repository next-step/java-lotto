package step4.view;

import step4.domain.lotto.LottoGame;
import step4.domain.lotto.LottoNumber;
import step4.domain.lotto.LottoResult;
import step4.domain.lotto.Rank;

import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {

    public static void printUserLotto(final LottoGame lottoGame) {
        lottoGame.getUserLottoList().forEach(userLotto -> {
            String result = userLotto.getLottoNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .map(Objects::toString)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + result + "]");
        });
    }

    public static void printLottoResult(final int purchaseAmount, final LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalWinningMoney = 0;
        for (Rank rank : lottoResult.getRankMap().keySet()) {
            if (rank.isNoMatch()) {
                continue;
            }
            totalWinningMoney += rank.getWinningMoney() * lottoResult.getRankMap().get(rank);
            printStatistics(lottoResult.getRankMap().get(rank), rank);
        }
        calculateRevenueRate(purchaseAmount, totalWinningMoney);
    }

    private static void printStatistics(final Integer count, final Rank rank) {
        if (rank == Rank.SECOND) {
            System.out.println(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치 ("
                    + rank.getWinningMoney() + "원) - "
                    + count + "개");
            return;
        }
        System.out.println(rank.getCountOfMatch() + "개 일치" + rank.getWinningMoney() + "원) - " + count + "개");
    }

    private static void calculateRevenueRate(final int purchaseAmount, final int totalWinningAmount) {
        double revenueRate = Math.floor((totalWinningAmount / (double) purchaseAmount) * 100) / 100;
        System.out.println("총 수익률은 " + revenueRate + "입니다.");
    }
}
