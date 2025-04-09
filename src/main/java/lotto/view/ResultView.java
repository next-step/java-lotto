package lotto.view;

import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoWallet;
import lotto.domain.model.MatchResult;
import lotto.domain.model.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ResultView {
    public static void printPurchasedLottos(LottoWallet lottoWallet, int manualLottoCount, int autoLottoCount) {
        printMessage("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
        for (LottoTicket lotto : lottoWallet.getLottos()) {
            printLottoTicket(lotto);
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

    private static void printLottoTicket(LottoTicket lotto) {
        String lottoTicketString = lotto.getNumbers().stream()
                .map(n -> String.valueOf(n.getNumber()))
                .collect(Collectors.joining(", ", "[", "]"));
        printMessage(lottoTicketString);
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
}
