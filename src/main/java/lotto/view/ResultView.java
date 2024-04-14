package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultView {

    private static final String COUNT_OF_LOTTO = "%d개를 구매했습니다.";
    private static final String RANK_RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String RATE_OF_RETURN_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String RANK_SECOND_RESULT_FORMAT = "%d개, 보너스 볼 일치 (%d원)- %d개";

    public void printLottoCount(List<Lotto> lottos) {
        System.out.println(String.format(COUNT_OF_LOTTO, lottos.size()));
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottos(lotto);
        }
    }

    private static void printLottos(Lotto lotto) {
        Set<LottoNumber> numbers = lotto.getNumbers();
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoNumber number : numbers) {
            stringBuilder.append(number.getNumber()).append(", ");
        }
        System.out.println("[" + stringBuilder.toString().replaceAll(", $", "") + "]");
    }

    public static void printWinningResult(List<Rank> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRankResult(makeLottoResult(ranks));
    }

    private static Map<Rank, Integer> makeLottoResult(List<Rank> ranks) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : ranks) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private static void printRankResult(Map<Rank, Integer> result) {
        List<Rank> ranks = Rank.getRanks();
        for (Rank rank : ranks) {
            String format = getFormat(rank);
            System.out.println(String.format(format, rank.getCountOfMatch(), rank.getReward(),
                    result.getOrDefault(rank, 0)));
        }
    }

    public static void printRateOfReturn(double calculateRateOfReturn) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(RATE_OF_RETURN_FORMAT, calculateRateOfReturn));
        if (calculateRateOfReturn < 1) {
            sb.append(RATE_OF_RETURN_MESSAGE);
        }
        System.out.println(sb);
    }

    private static String getFormat(Rank rank){
        if (rank.isSecond()){
            return RANK_SECOND_RESULT_FORMAT;
        }
        return RANK_RESULT_FORMAT;
    }
}
