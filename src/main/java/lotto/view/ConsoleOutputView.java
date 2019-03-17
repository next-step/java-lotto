package lotto.view;

import lotto.domain.LottoBundle;
import lotto.enums.LottoRank;
import lotto.vo.LottoResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConsoleOutputView {
    private ConsoleOutputView() {
    }

    public static void printNumberOfLottos(long numberOfLottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public static void printLottos(LottoBundle lottoBundle) {
        lottoBundle.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printWinStatistics(LottoResult lottoResult) {
        String format = "%d개 일치 (%,d원) - %d개%n";

        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        lottoRanks.sort(Comparator.reverseOrder());

        lottoRanks.forEach(lottoRank ->
            System.out.printf(format,
                    lottoRank.getMatchCount(), lottoRank.getPrizeMoney(), lottoResult.getNumberOfWin(lottoRank))
        );

        System.out.printf("총 수익률은 %,.2f입니다.%n", lottoResult.getTotalProfitRate());
    }
}
