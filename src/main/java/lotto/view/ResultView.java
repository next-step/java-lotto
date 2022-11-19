package lotto.view;

import lotto.model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {
    }

    public static void printBuyLottos(Lottos buyLotto) {
        for (Lotto lotto : buyLotto.getLottos()) {
            System.out.println(lottoNumbers(lotto));
        }
    }

    public static void printQuantity(int autoQuantity, ManualLotto manualLotto) {
        System.out.println("수동으로 " + manualLotto.getManualQuantity() + "장, 자동으로" + autoQuantity + "개를 구매했습니다.");
    }

    public static void printResult(RankGroup map, BigDecimal totalProfit) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println("3개 일치(5000원)- " + map.getRankCount().getOrDefault(Rank.FIVE, 0) + "개");
        System.out.println("4개 일치(50000원)- " + map.getRankCount().getOrDefault(Rank.FOUR, 0) + "개");
        System.out.println("5개 일치(1500000원)- " + map.getRankCount().getOrDefault(Rank.THREE, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + map.getRankCount().getOrDefault(Rank.TWO, 0) + "개");
        System.out.println("6개 일치(2000000000원)- " + map.getRankCount().getOrDefault(Rank.ONE, 0) + "개");

        System.out.println("총 수익률은 " + totalProfit + "입니다.");
    }

    private static List<Integer> lottoNumbers(Lotto lotto) {
        return lotto.getLotto().stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }
}
