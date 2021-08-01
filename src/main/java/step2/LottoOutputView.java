package step2;

import java.util.stream.IntStream;

public class LottoOutputView {
    public static void printLottoQuantity(LottoBucket lottoBucket) {
        System.out.printf("%d개를 구매했습니다.%n", lottoBucket.size());
    }

    public static void printAllLottoEntries(LottoBucket lottoBucket) {
        System.out.println(lottoBucket.toString());
    }

    public static void printLottoWinStatus(LottoWinStatistics lottoWinStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        IntStream.range(3, 7)
                .forEach(numberOfMatches -> {
                    LottoWin lottoWin = LottoWin.fromMatch(numberOfMatches).orElse(LottoWin.NONE_WIN);

                    int prize = lottoWin.prize();
                    int count = lottoWinStatistics.countLottoEntriesByLottoWin(lottoWin);

                    System.out.printf("%d개 일치 (%d원)- %d개\n", numberOfMatches, prize, count);
                });
    }

    public static void printProfitRate(LottoWinStatistics lottoWinStatistics) {
        double profitRate = lottoWinStatistics.getProfitRate(LottoStore.LOTTO_UNIT_PRICE);

        System.out.printf("총 수익률은 %.2f입니다.(1.00보다 낮은 경우 손해)\n", profitRate);
    }
}
