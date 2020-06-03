package lotto.view;

import lotto.domain.vo.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningSheet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final int NOT_LOSE_RATE = 1;
    private OutputView() {
    }

    public static void printNumberOfTicket(LottoMoney lottoMoney) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoMoney.getNumberOfTicket()));
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.stream()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getLottoNumbers()));
    }

    public static void printWinningStatistics(LottoResult lottoResult, LottoMoney lottoMoney) {
        System.out.println("당첨 통계");

        System.out.println("----------");

        System.out.println(makeStringStatistics(WinningSheet.FIFTH, lottoResult.countPrize(WinningSheet.FIFTH)));
        System.out.println(makeStringStatistics(WinningSheet.FOURTH, lottoResult.countPrize(WinningSheet.FOURTH)));
        System.out.println(makeStringStatistics(WinningSheet.THIRD, lottoResult.countPrize(WinningSheet.THIRD)));
        System.out.println(makeStringStatistics(WinningSheet.SECOND, lottoResult.countPrize(WinningSheet.SECOND)));
        System.out.println(makeStringStatistics(WinningSheet.FIRST, lottoResult.countPrize(WinningSheet.FIRST)));

        printRateOfReturn(lottoMoney.calculateRateOfReturn(lottoResult.sumAllPrize()));
    }

    private static String makeStringStatistics(WinningSheet winningSheet, int countPrize) {
        return String.format("%d개 일치 (%d원)- %d개", winningSheet.getMatchCount(), winningSheet.getPrice(), countPrize);
    }

    private static void printRateOfReturn(double rateOfReturn) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 %.2f 입니다.");

        if (rateOfReturn < NOT_LOSE_RATE) {
            stringBuilder.append("기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }

        System.out.println(String.format(stringBuilder.toString(), rateOfReturn));
    }
}
