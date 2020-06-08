package dev.dahye.lotto.view;

import dev.dahye.lotto.domain.LottoResult;
import dev.dahye.lotto.domain.Rank;
import dev.dahye.lotto.service.LottoMachine;

public class ResultView {
    public static void printPurchasedLottoTickets(LottoMachine lottoMachine) {
        System.out.println("수동으로 " + lottoMachine.getCountOfManualLotto() + "장, " +
                "자동으로 " + lottoMachine.getCountOfAutoLotto() + "장을 구입했습니다.");
        System.out.println(lottoMachine.getLottoTickets().toString());
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getCountOfMatch() + "개 일치" + printBonusBall(rank.isMatchBonusNumber())
                    + rank.getPrize() + "원) - "
                    + lottoResult.getTotalCountOf(rank) + "개");
        }
    }

    private static String printBonusBall(boolean isMatchBonusNumber) {
        return (isMatchBonusNumber ? ", 보너스 볼 일치(" : " (");
    }

    public static void printWinningRate(double number) {
        System.out.println("총 수익률은 " + number + "입니다.");
    }
}
