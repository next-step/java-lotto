package lotto.view;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.number.LottoNumber;
import lotto.domain.winning.WinningStatistics;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private final static String PRINT_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private final static String PRINT_STATISTICS = "당첨 통계\n---------";
    private static final String PRINT_RANK = "%d개 일치 (%d원)- %d개";
    private static final String PRINT_SECOND_RANK = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String PRINT_PROFIT_RATE = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printPurchasedLottoCount(int manualLottoCount, LottoTicket lottoTicket) {
        int totalLottoCount = lottoTicket.getLottoNumbersCount();
        int autoLottoCount = Math.max(totalLottoCount - manualLottoCount, 0);

        System.out.println(String.format(PRINT_LOTTO_COUNT, manualLottoCount, autoLottoCount));
    }

    public static void printPurchasedLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottoNumbers()
                .stream()
                .map(numbers -> numbers.getNumbers()
                        .stream()
                        .map(LottoNumber::getNumber)
                        .collect(Collectors.toList())
                )
                .forEach(System.out::println);
    }

    public static void printStatistics(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println(PRINT_STATISTICS);

        Map<LottoRank, Integer> lottoRank = winningStatistics.getLottoRank();
        lottoRank.keySet()
                .stream()
                .sorted(Comparator.comparingInt(LottoRank::getCountOfMatch)
                        .thenComparingInt(LottoRank::getBonusCountOfMatch)
                )
                .forEach(rank -> {
                    String print = PRINT_RANK;

                    if (LottoRank.SECOND.equals(rank)) {
                        print = PRINT_SECOND_RANK;
                    }

                    System.out.println(String.format(print, rank.getCountOfMatch(), rank.getWinningMoney(), lottoRank.get(rank)));
                });

        System.out.println(String.format(PRINT_PROFIT_RATE, winningStatistics.calculateProfit()));
    }
}
