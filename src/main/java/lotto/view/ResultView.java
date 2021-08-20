package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String ENTER = "\n";

    private ResultView() {
    }

    public static void printBuyLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.stream().forEach(lottoNumbers ->
                System.out.println(lottoNumbers.values()));
    }

    public static void printResultTitle() {
        System.out.println(ENTER + "당첨 통계");
        System.out.println("---------");
    }

    public static void printRankCount(Map<Rank, Integer> lottoResult) {
        lottoResult.entrySet().stream()
                .forEach(result -> System.out.println(String.format("%d개 일치 (%d원)- %d개",
                        result.getKey().getMatch(),
                        result.getKey().getRewards(),
                        result.getValue())));
    }

    public static void printProfit(BigDecimal totalRewards) {
        System.out.println(String.format("총 수익률은 %.2f 입니다.", totalRewards));
        if (totalRewards.compareTo(BigDecimal.valueOf(1)) < 0) {
            System.out.println("기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
