package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        printRankCount(lottoResult);
        printYield(lottoResult.calculateYield());
    }

    private static void printRankCount(LottoResult lottoResult) {
        Arrays.stream(Rank.values).filter(value -> value != Rank.NONE).forEach(value -> {
            System.out.printf("%d개 일치 (%s원)- %d개", value.getCorrectCount(), value.getReward(), lottoResult.countRank(value));
            System.out.println();
        });
    }

    private static void printYield(Double yield) {
        System.out.printf("총 수익률은 %.2f입니다.", yield);
    }
}
