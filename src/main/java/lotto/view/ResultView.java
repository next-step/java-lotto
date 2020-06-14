package lotto.view;

import lotto.domain.Prize;

import java.util.List;

public class ResultView {

    public static void printLottoResult(final List<Prize> prizes) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------------------------");
        System.out.println(getWinningString(Prize.FOURTH, getWinningCount(prizes, Prize.FOURTH)));
        System.out.println(getWinningString(Prize.THIRD, getWinningCount(prizes, Prize.THIRD)));
        System.out.println(getWinningString(Prize.SECOND, getWinningCount(prizes, Prize.SECOND)));
        System.out.println(getWinningString(Prize.FIRST, getWinningCount(prizes, Prize.FIRST)));
    }

    private static String getWinningString(final Prize prize, final int winningCount) {
        return String.format("%d개 일치 (%d)- %d개", prize.getCountOfMatch(), prize.getWinningMoney(), winningCount);
    }

    private static int getWinningCount(final List<Prize> prizes, Prize prize) {
        int count = 0;

        if (prizes.stream().anyMatch((v) -> v.equals(prize))) {
            count++;
        }
        return count;
    }
}
