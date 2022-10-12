package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningInformation;
import lotto.domain.WinningStatistics;

import java.math.BigDecimal;
import java.util.List;

import static lotto.domain.WinningInformation.*;

public class OutputView {

    private static final String MATCHES_COUNT_FORMAT = "%s개 일치 (%s원)- %s개\n";
    private static final List<WinningInformation> WINNING_INFORMATIONS =
            List.of(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, SIX_MATCHES);

    private OutputView() {
    }

    public static void printGeneratedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
        System.out.println();
    }
    
    public static void printWinningStatistics(WinningStatistics winningStatistics, BigDecimal purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        WINNING_INFORMATIONS.forEach(it -> {
            System.out.printf(MATCHES_COUNT_FORMAT, it.getMatchesCount(), it.getAmount(), winningStatistics.countSame(it));
        });
        System.out.printf("총 수익률은 %s입니다.", winningStatistics.calculateYield(purchaseAmount));
    }
}
