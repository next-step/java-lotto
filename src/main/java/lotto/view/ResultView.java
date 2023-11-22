package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Rank;

import java.util.*;

public class ResultView {

    private ResultView() {
    }

    public static void printPurchasedLottoNumbers(List<LottoNumber> lottoNumbers) {
        for(int i=0; i<lottoNumbers.size();i++) {
            System.out.println(lottoNumbers.get(i).getNumbers());
        }
    }

    public static void printPurchaseCount(int input) {
        System.out.println(input + "개를 구매했습니다.");
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
