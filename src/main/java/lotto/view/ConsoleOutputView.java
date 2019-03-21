package lotto.view;

import lotto.domain.ticket.LottoBundle;
import lotto.enums.LottoRank;
import lotto.vo.LottoGameResult;
import lotto.vo.LottoWinResult;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsoleOutputView {
    private static final String COMMON_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개%n";
    private static final String SECOND_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";

    private ConsoleOutputView() {
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printNumberOfLottos(long numberOfLottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public static void printLottos(LottoBundle lottoBundle) {
        lottoBundle.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printStatistics(LottoGameResult lottoGameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printLottoWinResult(lottoGameResult.getLottoWinResult());
        printTotalProfitRate(lottoGameResult);
    }

    private static void printLottoWinResult(LottoWinResult lottoWinResult) {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        Collections.reverse(lottoRanks);

        lottoRanks.forEach(lottoRank -> {
            long lottoRankCount = lottoWinResult.getLottoRankCount(lottoRank);
            String resultFormat = ((LottoRank.SECOND == lottoRank) ? SECOND_RESULT_FORMAT : COMMON_RESULT_FORMAT);

            System.out.printf(resultFormat,
                    lottoRank.getMatchCount(), lottoRank.getPrizeMoney(), lottoRankCount);
        });
    }

    private static PrintStream printTotalProfitRate(LottoGameResult lottoGameResult) {
        return System.out.printf("총 수익률은 %.2f입니다", lottoGameResult.getTotalProfitRate());
    }
}
