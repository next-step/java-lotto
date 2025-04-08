package lotto.view;

import lotto.domain.model.LottoNumbers;
import lotto.domain.model.LottoWallet;
import lotto.domain.model.MatchResult;
import lotto.domain.model.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ResultView {
    public static void printPurchasedLottos(LottoWallet lottoWallet) {
        int count = lottoWallet.getCount();
        printMessage(count + "개를 구매했습니다.");
        for (LottoNumbers lotto : lottoWallet.getLottos()) {
            printLottoNumbers(lotto.getNumbers());
        }
    }

    public static void printMatchResult(MatchResult matchResults, int purchaseAmount) {
        printMessage("당첨 통계");
        printMessage("---------");
        Rank[] ranks = Rank.values();
        Arrays.sort(ranks, Comparator.comparingInt(Rank::getCountOfMatch).reversed());
        for (Rank rank : ranks) {
            printMatchCount(rank, matchResults);
        }
        double profit = matchResults.calculateProfit(purchaseAmount);
        printProfit(profit);
    }

    private static void printLottoNumbers(List<Integer> lottoNumbers) {
        String formattedNumbers = arrayToString(lottoNumbers);
        printMessage(formattedNumbers);
    }

    private static void printMatchCount(Rank rank, MatchResult matchResults) {
        if (rank == Rank.MISS) {
            return;
        }
        String description = rank.getCountOfMatch() + "개 일치";
        if (rank == Rank.SECOND) {
            description += " + 보너스 볼 일치";
        }
        int price = rank.getWinningMoney();
        int count = matchResults.getCount(rank);
        printMessage(description + " (" + price + "원)- " + count + "개");
    }

    private static void printProfit(double profit) {
        printMessage("총 수익률은 " + String.format("%.2f", profit) + "입니다.");
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String arrayToString(List<Integer> array) {
        return "[" + array.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
