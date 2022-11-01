package lotto.views;

import java.util.Arrays;
import java.util.List;
import lotto.domains.Lotto;
import lotto.domains.LottoStatistics;
import lotto.domains.Prize;

public enum ResultView {
    INSTANCE;

    public void printStatistics(LottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printCountEachPrize(statistics);

        System.out.printf("총 수익률은 %.2f입니다.", statistics.getYield());
        System.out.println();
    }

    private void printCountEachPrize(LottoStatistics statistics) {
        Arrays.stream(Prize.values())
                .filter(Prize::isWin)
                .forEach(prize -> printPrize(prize, statistics));
    }

    public void printPurchasedLottoList(List<Lotto> manualLottoList, List<Lotto> autoLottoList) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoList.size(), autoLottoList.size());
        System.out.println();
        manualLottoList.forEach(System.out::println);
        autoLottoList.forEach(System.out::println);
        System.out.println();
    }

    private void printPrize(Prize prize, LottoStatistics statistics) {
        String normalFormat = "%d개 일치 (%d원)- %d개";
        String bonusFormat = "%d개 일치, 보너스 볼 일치(%d원)- %d개";

        System.out.printf(prize == Prize.SECOND ? bonusFormat : normalFormat,
                prize.getCorrectCount(),
                prize.getReward(),
                statistics.getWinningCount(prize));
        System.out.println();
    }
}
