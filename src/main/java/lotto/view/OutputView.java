package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningInformation;
import lotto.domain.WinningStatistics;

import java.util.List;

import static lotto.domain.WinningInformation.*;

public class OutputView {

    private static final String MATCHES_COUNT_FORMAT = "%s개 일치 (%s원)- %s개\n";
    private static final List<WinningInformation> WINNING_INFORMATIONS =
            List.of(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, SIX_MATCHES);

    private OutputView() {
        throw new AssertionError("OutputView는 생성자를 호출할 수 없습니다.");
    }

    public static void printGeneratedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public static void printMoneyLeft(Money money) {
        System.out.printf("남은 금액는 %s원 입니다.\n\n", money);
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics, Money purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        WINNING_INFORMATIONS.forEach(it -> System.out.printf(
                MATCHES_COUNT_FORMAT,
                it.getMatchesCount(),
                it.getAmount(),
                winningStatistics.countSame(it)
        ));
        System.out.printf("총 수익률은 %s입니다.", winningStatistics.calculateYield(purchaseAmount));
    }
}
