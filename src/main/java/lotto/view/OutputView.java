package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printLottos(int manualLottoCount, List<Lotto> lottos) {
        printLottoCount(manualLottoCount, lottos);
        printLottos(lottos);
        System.out.println();
    }

    private static void printLottoCount(int manualLottoCount, List<Lotto> lottos) {
        int autoLottoCount = lottos.size() - manualLottoCount;
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.stream().map(Lotto::toString).forEach(System.out::println);
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
            printRankMessage(lottoResult, value);
            System.out.println();
        });
    }

    private static void printRankMessage(LottoResult lottoResult, Rank value) {
        if (value == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%s원)- %d개", value.getCorrectCount(), value.getReward(), lottoResult.countRank(value));
            return;
        }
        System.out.printf("%d개 일치 (%s원)- %d개", value.getCorrectCount(), value.getReward(), lottoResult.countRank(value));
    }

    private static void printYield(Double yield) {
        System.out.printf("총 수익률은 %.2f입니다.", yield);
    }
}
