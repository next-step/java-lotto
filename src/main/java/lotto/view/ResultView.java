package lotto.view;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoResult(LottoResult result) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", result.manualQuantity(), result.autoQuantity());
        result.lottoInfos().forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoStatistics(LottoStatisticsResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        result.rankStatistics()
                .forEach(System.out::println);

        System.out.printf("총 수익률은 %s 입니다.%n", result.profit());
    }
}
