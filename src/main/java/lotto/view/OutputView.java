package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinStatistics;
import lotto.domain.WinType;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String PRINT_DELIMITER = ", ";

    public static void purchaseHistory(Lottos lottos) {
        String purchaseMessage = String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                                               lottos.manualPurchaseQuantity(),
                                               lottos.purchaseQuantity());
        System.out.println(purchaseMessage);

        for (Lotto lotto : lottos.lottos()) {
            String printNumbers = lotto.numbers().stream().map(n -> String.valueOf(n.number()))
                                       .collect(Collectors.joining(PRINT_DELIMITER));
            System.out.println("[" + printNumbers + "]");
        }
    }

    public static void winningStatistics(WinStatistics winStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<WinType> winTypes = winStatistics.winStatistics();
        System.out.println("3개 일치 (5000원)- " + winTypes.stream().filter(w -> w == WinType.FIFTH).count() + "개");
        System.out.println("4개 일치 (50000원)- " + winTypes.stream().filter(w -> w == WinType.FOURTH).count() + "개");
        System.out.println("5개 일치 (1500000원)- " + winTypes.stream().filter(w -> w == WinType.THIRD).count() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winTypes.stream().filter(w -> w == WinType.SECOND).count() + "개");
        System.out.println("6개 일치 (2000000000원)- " + winTypes.stream().filter(w -> w == WinType.FIRST).count() + "개");

        System.out.println("총 수익률은 " + winStatistics.rateOfReturn() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
