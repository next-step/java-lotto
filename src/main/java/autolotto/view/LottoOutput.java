package autolotto.view;

import autolotto.constant.Rank;
import autolotto.domain.Lottos;

public class LottoOutput {
    public static void println(String printable) {
        System.out.println(printable);
    }

    public static void printBoard() {
        println("당첨통계");
        println("----------------");
    }

    public static void printResult(Rank rank, int countOfWinners) {
        println(createOutputFormat(rank, countOfWinners));
    }

    private static String createOutputFormat(Rank rank, int countOfWinners) {
        String outputFormat = Rank.isSecond(rank) ? "%s개 일치, 보너스볼 일치 (%d원) - %d개" : "%s개 일치 (%d원) - %d개";
        return String.format(outputFormat, rank.getCountOfMatch(), rank.getWinningMoney(), countOfWinners);
    }

    public static void printROI(final double ROI) {
        System.out.printf("총 수익률은 %.0f%%입니다. (100%%가 구매한 금액만큼 돈이 당첨된 것.) %n", ROI);
    }

    public static void printLottoNumbers(Lottos lottos) {
        lottos.getLottoNumbers()
                .forEach(lottoNumber -> println(lottoNumber.toString()));
    }
}
