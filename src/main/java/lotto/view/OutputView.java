package lotto.view;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.number.LottoNumber;
import lotto.domain.winning.WinningStatistics;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getLottoNumbersCount() + "개를 구매했습니다.");
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
        System.out.println("당첨 통계\n" + "---------");
        Map<LottoRank, Integer> lottoRank = winningStatistics.getLottoRank();
        lottoRank.keySet()
                .stream()
                .sorted(Comparator.comparingInt(LottoRank::getCountOfMatch))
                .forEach(rank -> {
                    System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + ")- " + lottoRank.get(rank) + "개");
                });

        System.out.println("총 수익률은 " + String.format("%.2f", winningStatistics.calculateProfit()) + "입니다.");
    }
}
