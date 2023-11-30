package step2.view;

import step2.domain.Prizes;

public class OutputView implements View {

    private static final String WINNING_STATISTICS = "당첨 통계";

    private static final String DEMARCATION_LINE = "---------";

    private static final String PRIZE = "%d개 일치 (%d원)- %d개";

    public void showPrize(Prizes prizes) {
        nextLine();
        System.out.println(WINNING_STATISTICS);
        System.out.println(DEMARCATION_LINE);
        printPrize(prizes);
    }

    private void printPrize(Prizes prizes) {
        prizes.getPrizesFormat().forEach(System.out::println);
        printProfit(prizes);
    }

    private void printProfit(Prizes prizes) {
        System.out.println(prizes.getTotalProfit());
    }
}
