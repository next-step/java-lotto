package lotto.view;

import lotto.domain.ticket.LottoBundle;
import lotto.enums.LottoRank;
import lotto.vo.LottoResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConsoleOutputView {
    private static final String COMMON_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개%n";
    private static final String SECOND_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";

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

        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        lottoRanks.sort(Comparator.reverseOrder());

        lottoRanks.forEach(lottoRank -> {
            long numberOfWin = lottoResult.getNumberOfWin(lottoRank);
            printLottoRankResults(lottoRank, numberOfWin);
        });

        System.out.printf("총 수익률은 %,.2f입니다.%n", lottoResult.getTotalProfitRate());
    }

    private static void printLottoRankResults(LottoRank lottoRank, long numberOfWin) {
        String resultFormat = (LottoRank.SECOND == lottoRank ? SECOND_RESULT_FORMAT : COMMON_RESULT_FORMAT);
        int matchCount = (LottoRank.SECOND == lottoRank ?
                LottoRank.SECOND.getMatchCount() - LottoRank.BONUS_NUMBER_MATCH_COUNT : lottoRank.getMatchCount());

        System.out.printf(resultFormat,
                matchCount, lottoRank.getPrizeMoney(), numberOfWin);
    }
}
