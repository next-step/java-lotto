package lotto.view;

import lotto.domain.Prizes;

public class OutputView implements View {

    private static final String WINNING_STATISTICS = "당첨 통계";

    private static final String DEMARCATION_LINE = "---------";

    private static final String PRIZE_FORMAT = "%s개 일치 (%d원)- %d개";

    private static final String PROFIT_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    public void showPrize(Prizes prizes) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DEMARCATION_LINE);
        printPrizes(prizes);
        printTotalProfit(prizes);
    }

    private void printPrizes(Prizes prizes) {
        prizes.findWinPrizes().forEach(prize -> {
                print(PRIZE_FORMAT
                    , prize.getCorrectCount()
                    , prize.getWinningMoney().intValue()
                    , prizes.howManyGetPrize(prize.getCorrectCount())
                );
                nextLine();
            }
        );
    }

    private void printTotalProfit(Prizes prizes) {
        Double profitNumber = prizes.profit();
        print(PROFIT_FORMAT, prizes.profit(), getProfitKorean(profitNumber));
    }

    private String getProfitKorean(double profit) {
        if (profit > 1) {
            return "이익";
        }

        if (profit < 1) {
            return "손해";
        }
        return "본전";
    }
}
