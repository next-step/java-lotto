package lotto.view;

import lotto.Lotto;
import lotto.Lottos;
import lotto.Number;

import java.util.List;
import java.util.Set;

public class Output {
    private Output() {
    }

    public static void printPurchaseRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedLotto(Lottos lottos) {
        System.out.println("구입금액을 입력해 주세요.");
        printLotto(lottos.getLottos());
    }

    private static void printLotto(List<Lotto> numbers) {
        for (Lotto number : numbers) {
            System.out.println(number);
        }
        System.out.println();
    }

    public static void printWinnerNumbersRequest() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printResult(Lottos lottos, Set<Number> winnerNumbers) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", lottos.numberOfFourthRank(winnerNumbers));
        System.out.printf("4개 일치 (50000원)- %d개\n", lottos.numberOfThirdRank(winnerNumbers));
        System.out.printf("5개 일치 (1500000원)- %d개\n", lottos.numberOfSecondRank(winnerNumbers));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", lottos.numberOfFirstRank(winnerNumbers));
        if (lottos.hasBenefit(winnerNumbers)) {
            System.out.printf("총 수익률은 %.2f입니다.(어떻게 하셧죠??????)", lottos.calculateProfitRate(winnerNumbers));
            return;
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lottos.calculateProfitRate(winnerNumbers));
    }
}
