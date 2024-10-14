package lotto.view;

import lotto.constant.Prize;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class ResultView {

    private static final StringBuilder sb = new StringBuilder();
    private static final EnumMap<Prize, String> prizeMap = new EnumMap<>(Prize.class);

    static {
        prizeMap.put(Prize.FIFTH, "3개 일치 (5000원)-");
        prizeMap.put(Prize.FOURTH, "4개 일치 (50000원)-");
        prizeMap.put(Prize.THIRD, "5개 일치 (1500000원)-");
        prizeMap.put(Prize.SECOND, "5개 일치, 보너스 볼 일치(30000000원) -");
        prizeMap.put(Prize.FIRST, "6개 일치 (2000000000원)-");
    }

    public void printLottoNumbers(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
        System.out.println();
    }

    public void printResult(EnumMap<Prize, Integer> countMap, String profitRate) {
        printStatistics(countMap);
        printProfitRate(profitRate);
        System.out.println(sb.toString());
    }

    private static void printStatistics(EnumMap<Prize, Integer> countMap) {
        sb.append("\n").append("당첨 통계").append("\n").append("---------").append("\n");
        Arrays.stream(Prize.values())
                .filter(p -> p != Prize.MISS)
                .forEach(p -> {
                    sb.append(prizeMap.get(p)).append(" ").append(countMap.getOrDefault(p, 0)).append("개").append("\n");
                });
    }

    private static void printProfitRate(String profitRate) {
        sb.append("총 수익률은 ").append(profitRate).append("입니다. ");
        if (Double.parseDouble(profitRate) < 1) {
            sb.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)").append("\n");
        }
    }

    public void printLottoAmount(int amount, int total) {
        System.out.println("수동으로 " + amount + "장, 자동으로 " + (total - amount) + "개를 구매했습니다.");
    }
}
