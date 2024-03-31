package lottogame.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lottogame.domain.LottoNumber;
import lottogame.domain.Lottos;
import lottogame.domain.Number;
import lottogame.domain.Rank;

public class ResultView {

    private static final String MESSAGE_COUNT_OF_PURCHASE_LOTTOS = "%d개를 구매했습니다.";
    private static final String RANKS_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String RANKS_SECOND_FORMAT = "%d개, 보너스 볼 일치 (%d원)- %d개";
    private static final String RETURN_OF_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String RETURN_OF_RATE_MESSAGE_INFORMATION = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String MANUAL_AUTO_LOTTOS_COUNT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    private ResultView() {
    }

    public static void printLottos(List<Lottos> lottoses) {
        for (Lottos lottos : lottoses) {
            printLottos(lottos);
        }
    }

    public static void printCountOfPurchaseLottos(List<Lottos> lottos) {
        System.out.println(String.format(MESSAGE_COUNT_OF_PURCHASE_LOTTOS, lottos.size()));
    }

    public static void printWinningResult(List<Rank> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRanks(makeLottoResult(ranks));
    }

    public static void printReturnOfRate(double returnOfRate) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(RETURN_OF_RATE_MESSAGE_FORMAT, returnOfRate));
        if (returnOfRate < 1) {
            sb.append(RETURN_OF_RATE_MESSAGE_INFORMATION);
        }
        System.out.println(sb);
    }

    public static void printLinkBreak() {
        System.out.println();
    }

    private static Map<Rank, Integer> makeLottoResult(List<Rank> ranks) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : ranks) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private static void printRanks(Map<Rank, Integer> result) {
        List<Rank> ranks = Rank.getRanks();
        for (Rank rank : ranks) {
            String format = selectFormat(rank);
            System.out.println(String.format(format, rank.getNumOfWinnings(), rank.getPrize(),
                    result.getOrDefault(rank, 0)));
        }
    }

    private static String selectFormat(Rank rank) {
        if (rank.isSecond()) {
            return RANKS_SECOND_FORMAT;
        }
        return RANKS_FORMAT;
    }

    private static void printLottos(Lottos lottos) {
        List<LottoNumber> numbers = lottos.getNumbers();
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoNumber number : numbers) {
            stringBuilder.append(number.getValue()).append(", ");
        }
        System.out.println("["+stringBuilder.toString().replaceAll(", $", "")+"]");
    }

    public static void printAutoAndManualLottosCount(List<Lottos> multipleManualLottos,
            List<Lottos> multipleAutoLottos) {
        System.out.println(
                String.format(MANUAL_AUTO_LOTTOS_COUNT_FORMAT, multipleManualLottos.size(), multipleAutoLottos.size()));
    }
}
