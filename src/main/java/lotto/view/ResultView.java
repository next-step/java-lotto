package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {
    }

    public static void printPurchaseCount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }

    public static void printPurchasedLottoNumbers(LottoTicket lottoTicket) {
        List<LottoNumbers> tickets = lottoTicket.getLottoTicket();

        for (LottoNumbers numbers : tickets) {
            System.out.println(numbersToList(numbers.getLottoNumbers()));
        }
    }

    private static List<Integer> numbersToList(Set<LottoNumber> numbers) {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public static void printWinningStatistics() {
        System.out.println("당첨 통계\n---------");
    }

    public static void showLottoResult(HashMap<Rank, Integer> lottoResult, int purchaseAmount) {
        long sum = 0;
        printWinningStatistics();

        for (Rank rank : lottoResult.keySet()) {
            sum += rank.getPrize() * lottoResult.get(rank);
            printWinningResult(rank, lottoResult.get(rank));
        }
        double percentage = sum / (double) purchaseAmount;
        printProfitPercentage(percentage);
    }

    public static void printWinningResult(Rank rank, int count) {
        if (rank.getPrize() == 0) {
            return;
        }
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", rank.getCount(), rank.getPrize(), count);
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개\n", rank.getCount(), rank.getPrize(), count);
    }

    public static void printProfitPercentage(double percentage) {
        System.out.printf("총 수익률은 %.2f입니다.", percentage);
    }
}
