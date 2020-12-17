package step3.view;

import step3.domain.LottoResult;
import step3.domain.Rank;
import step3.domain.Lotto;
import step3.domain.LottoNumber;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private ResultView() {

    }

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.print("[");
            printLoopLottoNumbers(lotto);
            System.out.println("]");
        }
    }
    private static void printLoopLottoNumbers(Lotto lotto) {
        Iterator<LottoNumber> iterator = lotto.getLotto().iterator();

        while (iterator.hasNext()) {
            LottoNumber lottoNumber = iterator.next();
            System.out.print("" + lottoNumber.getNumber());
            checkLottoNumbersLastIterator(iterator);
        }
    }
    private static void checkLottoNumbersLastIterator(Iterator iterator) {
        if (iterator.hasNext()) {
            System.out.print(", ");
        }
    }

    public static void printWinCounts(LottoResult lottoResult) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (Rank rank : Rank.values()) {
            int rankMatchCount = rank.getCountOfMatch();
            boolean rankMatchBonus = rank.getBonus();
            List<Rank> filterRanks = lottoResult.getRanks().stream()
                    .filter(r -> r.getCountOfMatch() == rankMatchCount && r.getBonus() == rankMatchBonus)
                    .collect(Collectors.toList());

            System.out.println(rank.getMessage() + " (" + rank.getWinningMoney() + ")원- " + filterRanks.size() + "개");
        }
    }

    public static void printTotalRevenue(BigDecimal totalRevenue) {
        System.out.println("총 수익률은 " + totalRevenue + "입니다.");
    }
}
