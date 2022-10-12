package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningInformation;
import lotto.domain.WinningStatistics;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;

import static lotto.domain.WinningInformation.THREE_MATCHES;
import static lotto.domain.WinningInformation.FOUR_MATCHES;
import static lotto.domain.WinningInformation.FIVE_MATCHES;
import static lotto.domain.WinningInformation.SIX_MATCHES;

public class OutputView {

    private static final PrintStream OUTPUT = System.out;
    private static final String MATCHES_COUNT_FORMAT = "%s개 일치 (%s원)- %s개\n";
    private static final List<WinningInformation> WINNING_INFORMATIONS =
            List.of(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, SIX_MATCHES);

    private OutputView() {
    }

    public static void printGeneratedLottos(List<Lotto> lottos) {
        OUTPUT.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(OUTPUT::println);
        OUTPUT.println();
    }
    
    public static void printWinningStatistics(WinningStatistics winningStatistics, BigDecimal purchaseAmount) {
        OUTPUT.println("당첨 통계");
        OUTPUT.println("---------");
        WINNING_INFORMATIONS.forEach(it -> {
            OUTPUT.printf(MATCHES_COUNT_FORMAT, it.getMatchesCount(), it.getAmount(), winningStatistics.countSame(it));
        });
        OUTPUT.printf("총 수익률은 %s입니다.", winningStatistics.calculateYield(purchaseAmount));
    }
}
