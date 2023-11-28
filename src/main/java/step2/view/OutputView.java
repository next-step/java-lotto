package step2.view;

import step2.domain.WinPrizes;

public class OutputView {

    private static final String WINNING_STATISTICS = "당첨 통계";

    private static final String DEMARCATION_LINE = "---------";

    private static final String PRIZE = "%d개 일치 (%d원)- %d개";

    public void showPrize(WinPrizes winPrizes) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DEMARCATION_LINE);

        System.out.println(winPrizes.getPrizesFormat());
//        winPrizes.getPrizeList().forEach();
    }
}
