package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoResult;
import step2.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchasePrice() {
        printMessage(PURCHASE_PRICE);
    }

    public static void printPurchaseCount(int purchaseCount) {
        printMessage(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            printMessage(lotto.getNumbers().toString());
        }
    }

    public static void printWinNumber() {
        printMessage("");
        printMessage(WIN_NUMBER);
    }

    public static void printWinCounts(LottoResult lottoResult) {
        printMessage("");
        printMessage("당첨 통계");
        printMessage("--------");

        for (Rank rank : Rank.values()) {
            int rankMatchCount = rank.getMatchCount();
            List<Rank> filterRanks = lottoResult.getRanks().stream()
                    .filter(r -> r.getMatchCount() == rankMatchCount)
                    .collect(Collectors.toList());

            printMessage(rankMatchCount + "개 일치 (" + rank.getWinPrice() + ")원- " + filterRanks.size() + "개");
        }
    }

    public static void printTotalRevenue(double totalRevenue) {
        printMessage("총 수익률은 " + totalRevenue + "입니다.");
    }
}
