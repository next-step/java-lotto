package lotto.view;

import lotto.model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoNumbers(LottoCollection buyLotto) {
        for (Lotto lotto : buyLotto.getLottos()) {
            System.out.println(getLottoList(lotto));
        }
    }

    public static void printQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printResult(MatchingCollection matchingCollection, BigDecimal totalProfit) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println("3개 일치(5000원)- " + matchingCollection.getMatchCollection().getOrDefault(Rank.THREE, 0) + "개");
        System.out.println("4개 일치(50000원)- " + matchingCollection.getMatchCollection().getOrDefault(Rank.FOUR, 0) + "개");
        System.out.println("5개 일치(1500000)- " + matchingCollection.getMatchCollection().getOrDefault(Rank.FIVE, 0) + "개");
        System.out.println("6개 일치(2000000000)- " + matchingCollection.getMatchCollection().getOrDefault(Rank.SIX, 0) + "개");

        System.out.println("총 수익률은 " + totalProfit + "입니다.");
    }

    private static List<Integer> getLottoList(Lotto lotto) {
        return lotto.getLotto().stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }
}
